import {createRouter, createWebHashHistory} from 'vue-router'
//-异步加载组件
import { defineAsyncComponent } from 'vue'

//-路由规则
const myRoutes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        name: "Login",
        component: defineAsyncComponent(()=>import('../components/Login.vue'))
    },
    {
        path: '/horBill',
        name: "PieEchartsBill",
        component: defineAsyncComponent(()=>import('../components/PieEchartsBill.vue'))
    },
    {
        path: '/pieBill',
        name: "HorizontalBarChartsBill",
        component: defineAsyncComponent(()=>import('../components/HorizontalBarChartsBill.vue'))
    },
    {
        path: '/form',
        name: "Form",
        component: defineAsyncComponent(()=>import('../components/Form.vue'))
    },
    {
        path: '/table',
        name: "table",
        component: defineAsyncComponent(()=>import('../components/table.vue'))
    },
    {
        path: '/monthHead',
        name: "monthHead",
        component: defineAsyncComponent(()=>import('../components/monthHead.vue'))
    },
    {
        path: '/yearBill',
        name: "yearBill",
        component: defineAsyncComponent(()=>import('../components/YearBill.vue'))
    },
    {
        path: '/monthBill',
        name: "monthBill",
        component: defineAsyncComponent(()=>import('../components/monthBill.vue'))
    },

]
//-创建路由对象
const router = createRouter({
    history: createWebHashHistory(),
    routes: myRoutes
})

//全局守卫  访问非Login界面时，验证是否已登录
router.beforeEach((to,from,next)=>{
    //判断是否已登录 查sessionStorage中是否有isAuthenticated信息
    // let isAuthenticated = sessionStorage.getItem("isAuthenticated")
    // //判断路由的别名不是登录且未进行登录认证，就跳转去登录
    // if(to.name!="Login"&&!isAuthenticated){
    //     next({name: "Login"})
    // }else if(to.name=="Login"&&isAuthenticated){//已登录，不允许退回到登录页面
    //     next({name:"Home"})
    // }else{
        next()
    // }
})

//-将路由暴露出去，其他文件才能访问
export default router



