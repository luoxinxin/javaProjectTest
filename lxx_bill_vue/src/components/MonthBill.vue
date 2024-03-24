<template>
  <div class="common-layout">
    <el-container>
      <el-header class="h160">
        <div style="display: flex;">
          <el-avatar style="align-items: center;margin-top: 18px" class="mr20" :size="50" :src="circleUrl" />
          <div>
            <h1 style="font-size: 24px;line-height: 1.5">月收入报告</h1>
            <div class="flex" style="margin-bottom: 20px">
              <el-input class="wh230" v-model="data.year" type="number" placeholder="年份"></el-input>
              <el-input class="wh230" v-model="data.month" type="number" placeholder="月份"></el-input>
              <el-button class="wh230" type="primary" @click="fetchData()">获取数据</el-button>
            </div>
          </div>
        </div>

        <monthHead :stringTe="stringTe" :tableDataProp="tableDataProp"/>
      </el-header>
      <div style="display: flex;justify-content: space-between;padding: 0 20px;">
        <div style="flex: 1">

          <div class="flex">
            <div class="mr20">
              <h1 style="font-size: 24px;line-height: 1.5">支出</h1>
              <incomeTable :stringTe="stringTe" :tableDataProp="tableDataProp" :type="'支出'"/>
            </div>
            <div>
              <div style="width:600px">
                <h1 style="font-size: 24px;line-height: 1.5">支出图</h1>
                <pieEchartsBill :data2="data2" />
              </div>
              <div style="width: 350px;margin-top: 20px">
                <h1 style="font-size: 24px;line-height: 1.5">收入</h1>
                <incomeTable :stringTe="stringTe" :tableDataProp="tableDataProp" :type="'收入'" />
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
import incomeTable from "./table.vue";
import monthHead from "./monthHead.vue";
import yearHead from "./YearHead.vue";
import {ref, onMounted,reactive} from "vue";

export default {
  name: 'yearBill',
  components: {
    pieEchartsBill,
    incomeTable,
    monthHead,
    yearHead
  },
  data() {
    return {}
  },
  setup() {
    const data = ref({
      year: 2023,
      month: 1,
      typeName: '支出'
    })
    const data2 = ref({})
    const stringTe = ref(0)
    let tableDataProp = ref({
      year:2023,
      month:1,
      typeName: '支出'
    })

    const fetchData = () => {
      let fetchDataOj = data.value;
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
            let obj = {
              year: data.value.year,
              month: data.value.month,
            }
            tableDataProp.value = obj
          })
          .catch(error => console.error('Error:', error));
    }
    onMounted(() => {
      fetchData();
    });
    return {
      data,
      fetchData,
      tableDataProp,
      data2,
      stringTe
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
