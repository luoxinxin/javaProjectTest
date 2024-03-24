<template>

  <div id="app">
    <div class="flex">
      <el-input class="wh230" v-model="data.year" type="number" placeholder="年份" ></el-input>
      <el-input class="wh230" v-model="data.month" type="number" placeholder="月份"></el-input>
<!--      <el-input v-model="data.startDay" type="number" placeholder="开始日期"></el-input>-->
<!--      <el-input v-model="data.endDay" type="number" placeholder="结束日期"></el-input>-->
      <el-select v-model="data.typeName" placeholder="类型">
        <el-option label="支出" value="支出"></el-option>
        <el-option label="收入" value="收入"></el-option>
      </el-select>
    </div>
    <el-button type="primary" @click="fetchData()">获取数据</el-button>
    <div ref="echartsRef" id="main"></div>
  </div>

</template>


<script>
import {nextTick, ref} from 'vue'
import * as echarts from 'echarts';

export default {
  setup() {
    const data = ref({
      year: 2023,
      month: 1,
      startDay: '1',
      endDay: '1',
      typeName: '收入'
    })

    const echartsRef = ref(null);

    const fetchData =() =>{
      let fetchDataOj = data.value;
      fetch('http://localhost:8080/statistics/payOutOrInCome', {
        method: 'POST',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(fetchDataOj),
      })
          .then(response => response.json())
          .then(data => echarts1(data.data))
          .catch(error => console.error('Error:', error));
    }

    const echarts1 = (data)=> {
      console.log(data);
      const chartDom = echartsRef.value
      // const chartDom = document.getElementById('main');
      const myChart = echarts.init(chartDom);
      let option;
      let list = [];
      for (const i in data) {
        console.log(i);
        list.push({
          name: i,
          value: data[i]
        })
      }
      console.log(list);
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

    return {
      data,
      fetchData,
      echartsRef
    }
  },
}

</script>


<style scoped>
  #main {
    width: 600px;
    height: 600px;
    background-color: #00F2F1;
  }
  .wh230{
    width: 200px;
  }
  .flex{
    display: flex;
    justify-content: space-between;
  }
</style>
