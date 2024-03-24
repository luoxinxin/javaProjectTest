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

<script>
import {defineComponent, ref, onMounted, watch} from 'vue';
import axios from "axios";
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
  name: 'yearHead',
  components: {
    tableTe
  },
  setup(props) {
    watch(() => props.tableDataProp, (newValue, oldValue) => {
      getData()
    })
    console.log(props,"yearHead")
    const data = {};
    const obj = ref(data);
    const getData = async () => {
      try {
        const reqData = {
          "year": props.tableDataProp.year
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
<style scoped>
:deep(.my-label) {
  background: var(--el-color-success-light-9) !important;
}

:deep(.my-content) {
  background: var(--el-color-danger-light-9);
}
</style>
