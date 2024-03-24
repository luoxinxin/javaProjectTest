import { createApp } from 'vue'
import App from './App.vue'
//导入axios框架
import Axios from 'axios'
//导入bootstrap样式
import 'bootstrap/dist/css/bootstrap.min.css'

import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'

// // 如果您正在使用CDN引入，请删除下面一行。
// import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//
//
// for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
//     app.component(key, component)
// }

//导入 router框架
import Router from './router/index.js'

const app = createApp(App)
app.use(ElementPlus)
app.directive('copy', {
    mounted(el, binding) {
        el.addEventListener('click', function () {
            const textArea = document.createElement('textarea');
            textArea.value = binding.value;
            document.body.appendChild(textArea);
            textArea.select();
            document.execCommand('copy');
            app.config.globalProperties.$message.success('复制成功：' + binding.value)
            document.body.removeChild(textArea);
        });
    },
});
app.use(Router)
app.provide("$axios", Axios)
app.mount('#app')