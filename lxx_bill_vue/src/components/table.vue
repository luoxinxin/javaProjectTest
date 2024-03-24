<template>
  <el-table size="small" border :data="tableData" style="width: 100%">
<!--    <el-table-column label="业务" width="180" >-->
<!--      <template #default="{ row }">-->
<!--        <el-tooltip-->
<!--            class="box-item"-->
<!--            effect="dark"-->
<!--            :content="`一键复制：${row.label}`"-->
<!--            placement="top"-->
<!--        >-->
<!--          <div v-copy="row.label" class="my-label">{{row.label}}</div>-->
<!--        </el-tooltip>-->
<!--      </template>-->
<!--    </el-table-column>-->
    <el-table-column prop="label" label="业务" width="180" />
    <el-table-column prop="value" label="金额" width="180" />
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
    })
    const tableData = ref([]);
    const fetchFormItems= async() => {
      try {

        const reqData = {
          "year": props.tableDataProp.year,
          "month": props.tableDataProp.month,
          "typeName": props.type
        }
        // 使用 Axios 发送请求
        const response = await axios.post('http://localhost:8080/statistics/payOutOrInCome', reqData);

        // 处理接口返回的数据，假设返回的数据是一个包含 label 的数组
        const apiData = response.data.data;
        console.log(apiData);
        const list =[];
        for (const i in apiData) {
          list.push({
            label: i,
            value: apiData[i]
          })
        }
        console.log(list);
        tableData.value = list;
        // 更新 formItems

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
