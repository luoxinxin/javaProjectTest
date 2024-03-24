<template>
  <div class="container">
    <el-row class="h-60">
    </el-row>
    <el-row>
      <el-col :span="8">
      </el-col>
      <el-col :span="8" class="bg-primary-subtle p-10">
        <el-form :model="loginForm"
                 class="login-container" label-position="left"
                 label-width="80px" v-loading="loading"  status-icon>
          <h4 class="text-center">系统登录</h4>
          <div style="margin: 20px" />
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="loginForm.email" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input  type="password" v-model="loginForm.pwd" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item class="text-center">
            <el-button type="primary" class="m-l-20" @click.native.prevent="toLogin()">Login</el-button>
            <el-button type="Reset" class="m-l-20" >Reset</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>
<script >
import { ref  } from 'vue'
import { useRouter } from 'vue-router';
export default {
  name: 'Login',
  setup() {
    const loading = ref(false);
    const loginForm = ref({
      email: 'super@a.com',
      pwd: '123123'
    });
    const router = useRouter()
    console.log(router)

    const toLogin = () => {
      console.log(router.push)
      router.push('/bill')
    };
    return {
      loading,
      loginForm,
      toLogin
    };
  }
}

</script>
<style>
.h-60{
  height: 60px;
}
.p-10{
  padding: 10px;
}
</style>