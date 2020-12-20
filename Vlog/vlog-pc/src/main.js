import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import layer from 'vue-layer'
import vuetify from '@/plugins/vuetify'
import 'vue-layer/lib/vue-layer.css';
axios.defaults.baseURL = 'http://ldk0.cn.utools.club/api'

Vue.use(VueAxios,axios)
Vue.prototype.$layer = layer(Vue);
Vue.prototype.$layer = layer(Vue, {
  msgtime: 3,//目前只有一项，即msg方法的默认消失时间，单位：秒
});

//引入富文本编辑器
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
Vue.use(VueQuillEditor);

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App)
}).$mount('#app')
