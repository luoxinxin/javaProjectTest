<template>
  <div id="horizon">
    <div ref="echartsRef1" @click="bigImg()" id="main1"></div>
    <el-button type="primary" @click="sendToFather()">加一年({{title.year}})</el-button>
    <el-dialog
      title="提示"
      v-model="dialogVisible"
      width="80%"
      top="10%"
      center
      :before-close="handleClose"
      @close="handleClose"
    >
      <div>
        <div ref="echartsRef2"  id="main2"></div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {onMounted, ref, watch,nextTick,inject} from 'vue'
import * as echarts from 'echarts';

export default {
  props: {
    tableDataProp: {
      type: Object,
      default:{}
    },
    dataObj: {
      type: Object,
      default:{}
    },
    type: {
      type: String,
      default:''
    },
    stringTe: {
      type: Number,
      default:null
    }
  },

  setup(props,context) {
    watch(() => props.tableDataProp, (newValue, oldValue) => {
      fetchData()
    })
    const title = inject('title')
    console.log(title,11111111111111111111111)
    const dialogVisible = ref(false)
    const bigImg = () => {
      console.log(1111,dialogVisible)
      dialogVisible.value = true
      nextTick(() => {
        horizontalEcharts(dataObj,'main2')
      })
    }
    const handleClose = () => {
      dialogVisible.value = false
    }
    let dataObj = {};

    const sendToFather = () => {
      console.log(1111,context)
      context.emit('emitFn',props.tableDataProp.year*1 + 1)
    }
    const fetchData = () => {
      let fetchDataOj = {year:props.tableDataProp.year};
      fetch('http://localhost:8080/statistics/monthIncomeExpenditureBalance', {
        method: 'POST',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(fetchDataOj),
      })
          .then(response => response.json())
          .then(data => {
            dataObj = data.data
            horizontalEcharts(data.data, 'main1')
          })
          .catch(error => console.error('Error:', error));
    }

    const horizontalEcharts = (data,dom)=> {
      var chartDom = document.getElementById(dom);
      var myChart = echarts.init(chartDom);
      var option;
      let arr = [];
      let arr2 = [];
      let arr3 = []
      let arr4 = []

      for (const key in data) {
        arr.push(key + '月')
        arr2.push(data[key].inComeAmount*1);
        arr3.push(data[key].payOutAmount*1);
        arr4.push(data[key].balance*1);
      }
      option = {
        title: {
          text: '年度账单'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01]
        },
        yAxis: {
          type: 'category',
          data: arr
        },
        series: [
          {
            name: '入账',
            type: 'bar',
            data: arr2
          },
          {
            name: '出账',
            type: 'bar',
            data: arr3
          },
          {
            name: '平衡收支',
            type: 'bar',
            data: arr4
          }
        ]
      };
      option && myChart.setOption(option);
    }
    //
    onMounted(() => {
      fetchData();
    });
    return {
      bigImg,
      dialogVisible,
      handleClose,
      sendToFather,
      title
    }
  },
}

</script>


<style scoped>
  #main1 {
    width: 580px;
    height: 200px;
    background-color: #00F2F1;
  }
  #main2{
    margin: 0 auto;
    width:calc(60vw);
    height: calc(60vh);
  }
</style>
