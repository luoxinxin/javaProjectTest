<template>
  <div class="common-layout">
    <el-container>
      <el-header class="h160">
        <div style="display: flex;">
          <el-avatar style="align-items: center;margin-top: 18px" class="mr20" size="50" v-model:src="imagePath" />
          <div>
            <h1 style="font-size: 24px;line-height: 1.5">年收入报告</h1>
            <div class="flex" style="margin-bottom: 20px">
              <el-input class="wh230" v-model="data.year" type="number" placeholder="年份"></el-input>
              <el-button class="wh230" type="primary" @click="fetchData()">获取数据</el-button>
            </div>
          </div>
        </div>
        <yearHead :stringTe="stringTe" :tableDataProp="tableDataProp"/>
      </el-header>
      <div style="justify-content: space-between;padding: 0 20px;">
        <div >
          <div class="flex">
            <div style="flex: 1" class="mr20">
              <h1 style="font-size: 24px;line-height: 1.5">年收入</h1>
              <div style="width:100%">
                <pieEchartsBill :data2="data2" />
              </div>
              <div style="width: 100%;margin-top: 20px">
                <incomeTable ref="childComponentRef1" :stringTe="stringTe" :tableDataProp="tableDataProp" :type="'支出'"/>
              </div>
            </div>
            <div style="flex: 1" class="mr20">
              <h1 style="font-size: 24px;line-height: 1.5">年支出</h1>
              <div style="width:100%">
                <pieEchartsBill :data2="data2" />
              </div>
              <div style="width: 100%;margin-top: 20px">
                <incomeTable ref="childComponentRef" :stringTe="stringTe" :tableDataProp="tableDataProp" :type="'收入'" />
              </div>
            </div>
            <div style="flex: 1">
              <h1 style="font-size: 24px;line-height: 1.5">年度摘要</h1>
              <div style="width:100%">
                <horizontalBarChartsBill @emitFn="emitFn" :stringTe="stringTe" :dataObj="data" :tableDataProp="tableDataProp" />
              </div>
              <div style="width: 100%;margin-top: 20px">
                <annualSummaryTable ref="childComponentRef2" :stringTe="stringTe" :tableDataProp="tableDataProp" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </el-container>
  </div>
</template>
<script>
import pieEchartsBill from "./PieEchartsBill.vue";
import payoutPieEchartsBill from "./PayoutPieEchartsBill.vue";
import incomeTable from "./table.vue";
import monthHead from "./monthHead.vue";
import yearHead from "./YearHead.vue";
import {ref, onMounted, provide} from "vue";
import horizontalBarChartsBill  from "./HorizontalBarChartsBill.vue";
import annualSummaryTable from "./AnnualSummaryTable.vue";
import lyy from '../assets/lyy.webp';
export default {
  name: 'yearBill',
  components: {
    pieEchartsBill,
    payoutPieEchartsBill,
    incomeTable,
    monthHead,
    yearHead,
    horizontalBarChartsBill,
    annualSummaryTable
  },
  setup() {
    const data = ref({
      year: 2023,
      // month: 1,
      typeName: '支出'
    })
    const imagePath = ref(lyy)
    const data2 = ref({})
    const stringTe = ref(0)
    let tableDataProp = ref({
      year:2023,
      // month:1,
      typeName: '支出'
    })
    provide('title',data)
    const childComponentRef = ref();
    const childComponentRef1 = ref();
    const fetchData = () => {
      stringTe.value = Math.random(0,100)
      let fetchDataOj = data.value;
      console.log(fetch);
      fetch('http://localhost:8080/statistics/payOutOrInCome', {
        method: 'POST',
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(fetchDataOj),
      })
          .then(response => response.json())
          .then((res) => {
            data2.value = res.data
            console.log(data)
            let obj = {
              year: data.value.year,
              month: data.value.month,
            }
            tableDataProp.value = obj
            console.log(tableDataProp,2222222)
            // childComponentRef.value.fetchFormItems();
            // childComponentRef1.value.fetchFormItems();
          })
          .catch(error => console.error('Error:', error));
    }

    const emitFn = (year) => {
      data.value.year = year;
      fetchData()
      console.log(year,'子组件传值改变父组件')
    }
    onMounted(() => {
      fetchData();
    });
    return {
      data,
      fetchData,
      childComponentRef,
      childComponentRef1,
      tableDataProp,
      data2,
      stringTe,
      imagePath,
      emitFn,

    }
  },
};
</script>
<style>
.common-layout {
  height: 100%;
}

.flex {
  display: flex;
}

.mr20 {
  margin-right: 20px;
}

.mb20 {
  margin-bottom: 20px;
}

.wh230 {
  width: 120px;
  margin: 0 5px;
}

.h160 {
  height: 160px;
}

</style>
