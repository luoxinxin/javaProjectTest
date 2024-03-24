<template>
  <div>
    <div class="block">
    <el-descriptions title="" :column="3" border>
      <el-descriptions-item
          label="收入"
          label-align="right"
          align="center"
          label-class-name="my-label"
          class-name="my-content"
          width="150px"
      >{{ obj.inComeAmount }}
      </el-descriptions-item
      >
      <el-descriptions-item
          label="支出"
          label-align="right"
          align="center"
          label-class-name="my-label"
          class-name="my-content"
          width="150px"
      >{{ obj.payOutAmount }}
      </el-descriptions-item
      >
      <el-descriptions-item
          label="余额"
          label-align="right"
          align="center"
          label-class-name="my-label"
          class-name="my-content"
          width="150px"
      >{{ obj.balance }}
      </el-descriptions-item
      >
    </el-descriptions>
    </div>
  </div>
</template>
<style scoped>
:deep(.my-label) {
  background: var(--el-color-success-light-9) !important;
}
:deep(.my-content) {
  background: var(--el-color-danger-light-9);
}
</style>
<script>
import {defineComponent, ref, onMounted, watch} from 'vue';
import PieEchartsBill from "./PieEchartsBill.vue";
import axios  from "axios";
import tableTe from "./table.vue";
export default defineComponent({
  props: {
    tableDataProp: {
      type: Object,
      default:{}
    },
    stringTe: {
      type: Number,
      default:null
    }
  },
  name: 'monthHead',
  components:{
    PieEchartsBill,
    tableTe
  },
  setup(props) {
    watch(() => props.tableDataProp, (newValue, oldValue) => {
      getData()
      // 在这里可以执行你的逻辑
    })
    const data = {};
    const obj = ref(data);
    const getData=async() => {
      try {
        const reqData = {
          "year": props.tableDataProp.year,
          "month": props.tableDataProp.month,
        }
        const response = await axios.post('http://localhost:8080/statistics/incomeExpenditureBalance', reqData);
        console.log(response);
        const apiData = response.data.data;
        console.log(apiData);
        obj.value = apiData;
        console.log(obj);
      } catch (error) {
        console.error('Error fetching form items:', error);
      }
    }
    onMounted(() => {
      getData();
    });
      return {
        obj
      };

  },
});
</script>
