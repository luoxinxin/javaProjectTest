<template>

  <div id="app">
    <div id="horizon">
      <div ref="echartsRef" @click="bigImg()" id="main"></div>
      <el-dialog
          title="提示"
          v-model="dialogVisible"
          width="80%"
          top="10%"
          center
          :before-close="handleClose"
          @close="handleClose"
      >
        <div class="">
          <div ref="echartsRef1" id="main3"></div>
        </div>
      </el-dialog>
    </div>
  </div>

</template>


<script>
import {nextTick, onMounted, ref, watch} from 'vue'
import * as echarts from 'echarts';

export default {
  props: {
    data2: {
      type: Object,
      default:{}
    }
  },
  setup(props,context) {
    watch(() => props.data2, (newValue, oldValue) => {
      echarts1(1)
      // 在这里可以执行你的逻辑
    })

    const dialogVisible = ref(false)
    const bigImg = () => {
      console.log(1111,dialogVisible)
      dialogVisible.value = true
      nextTick(() => {
        echarts1(2)
      })
    }
    const handleClose = () => {
      dialogVisible.value = false
    }

    const echartsRef = ref(null)
    const echartsRef1 = ref(null)

    const echarts1 = (num)=> {
      let echartsData = props.data2
      console.log(echartsData);
      let chartDom
      if(num == 1){
        chartDom = echartsRef.value
        console.log(chartDom,222)
      }else{
        chartDom = echartsRef1.value
      }
      const myChart = echarts.init(chartDom);
      let option;
      let list = [];
      for (const i in echartsData) {
        list.push({
          name: i,
          value: echartsData[i]
        })
      }
      option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: true,
              formatter(param) {
                return param.name + ' (' + param.percent + '%)';
              }
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: list
          }
        ]
      };
      option && myChart.setOption(option);
    }
    onMounted(() => {
      echarts1(1)
    })
    return {
      echartsRef,
      echartsRef1,
      bigImg,
      dialogVisible,
      handleClose
    }
  },
}

</script>


<style scoped>
  #main {
    width: 100%;
    height: 200px;
    background-color: #00F2F1;
  }
  #main3{
    margin: 0 auto;
    width:calc(60vw);
    height: calc(60vh);
  }
  .wh230{
    width: 230px;
  }
 .flex{
    display: flex;
  }
</style>
