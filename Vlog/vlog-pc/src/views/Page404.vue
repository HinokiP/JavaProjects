<template>
    <v-app>
        <!-- 顶部导航，父组件定位提供容器，引入封装的导航组件 -->
        <v-app-bar height="56px" elevation="12" fixed class="nav-transparent">
        <nav-bar></nav-bar>
        </v-app-bar>
        <div class="header" style="position:relative;height:768px;background-image: url(https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/wallpaper/kitten-snow-cute-stare-cold-animals.jpeg);">
            <h1 class="white--text txt">404 NOT FOUND</h1>
        </div>
          <my-footer></my-footer>
    </v-app>    
</template>

<script>
import NavBar from '../components/NavBar'
import MyFooter from '../components/MyFooter'
export default {
    components: {
        NavBar,
        MyFooter
    }
}
</script>

<style lang="scss" scoped>
.nav-transparent {
  background-color: transparent !important;
  background-image: none;
  box-shadow: none;
}
.txt {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 30px;
}
</style>