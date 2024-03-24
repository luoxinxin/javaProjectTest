<template>
  <el-table size="small" border :data="tableData" style="width: 100%">
    <el-table-column prop="month" label="月份" width="120" />
    <el-table-column prop="inComeAmount" label="月收入" width="120" />
    <el-table-column prop="payOutAmount" label="月支出" width="120" />
    <el-table-column prop="balance" label="月余额" width="120" />
  </el-table>
</template>

<script>
import {defineComponent, ref, onMounted, watch} from 'vue';
import axios from "axios";

export default {
  props: {
    tableDataProp: {
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
  name : 'table',
  setup(props){
    watch(() => props.tableDataProp, (newValue, oldValue) => {
      fetchFormItems()
      // 在这里可以执行你的逻辑
    })
    const tableData = ref([]);
    const fetchFormItems= async() => {
      try {
        const reqData = {
          "year": props.tableDataProp.year
        }
        const response = await axios.post('http://localhost:8080/statistics/monthIncomeExpenditureBalance', reqData);
        // 处理接口返回的数据，假设返回的数据是一个包含 label 的数组
        const apiData = response.data.data;
        const list =[];
        for (const i in apiData) {
          list.push({
            month: i,
            inComeAmount: apiData[i].inComeAmount,
            payOutAmount: apiData[i].payOutAmount,
            balance: apiData[i].balance
          })
        }
        tableData.value = list;
      } catch (error) {
        // console.error('Error fetching form items:', error);
      }
    }
    onMounted(() => {
      fetchFormItems();
    });
    return{
      tableData,
      fetchFormItems
    }
  }
}
</script>
