import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginStatus: false,
    avatar: '',
    gender: '',
    user: {
      id: 1,
      phone: '13174153016',
      password: 'e10adc3949ba59abbe56e057f20f883e',
      nickname: 'Hinoki',
      avatar: 'https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/avatar/bd15b2dd-56e9-49b3-8038-a501a76646ac.png',
      gender: 0,
      birthday: '2012-02-01',
      address: '江苏省徐州市云龙区',
      banner: '',
      signature: '彼岸花开 | 开到茶靡',
      createTime: '2020-12-08 23:52:40'
    }
  },
  getters: {},
  mutations: {
    //登陆成功后，用户数据存入本地存储
    login(state, user) {
      state.loginStatus = true
      state.user = user
      state.avatar = user.avatar
      localStorage.setItem('user', JSON.stringify(user))
    },
    //退出登录
    logout(state) {
      state.loginStatus = false
      state.user = {}
      state.avatar = ''
      localStorage.removeItem('user')
    },
    setAvatar(state, data) {
      state.avatar = data
    },
    editUserInfo(state, obj) {
      if(state.user) {
        state.user.nickname = obj.nickname
        state.user.password = obj.password
        state.user.avatar = obj.avatar
        state.user.gender = obj.gender
        state.user.birthday = obj.birthday
        state.user.address = obj.address
        localStorage.setItem('user', JSON.stringify(state.user))
      }
    }
  },
  actions: {}
})
