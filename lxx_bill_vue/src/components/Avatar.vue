<el-col :span="12">
<div class="sub-title">circle</div>
<div class="demo-basic--circle">
  <div class="block">
    <el-avatar :size="50" :src="circleUrl" />
  </div>
  <div v-for="size in sizeList" :key="size" class="block">
    <el-avatar :size="size" :src="circleUrl" />
  </div>
</div>
</el-col>