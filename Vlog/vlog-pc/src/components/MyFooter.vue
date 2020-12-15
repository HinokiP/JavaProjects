<template>
  <div class="footer-bg">
      <v-row justify="center" align="center">
          <v-col cols="12" md="12">
              © 2017-2020 Hinoki, 版权所有 站点总字数：74.751K
          </v-col>
          <v-col cols="12" md="12">
              本站已运行 2 年 75 天 15 小时 30 分钟 20 秒
          </v-col>
          <v-col cols="12" md="12">
              本站总访问量 74751 人次, 访客数 74751 人
          </v-col>
      </v-row>
  </div>
</template>

<script>
export default {
    name: 'MyFooter'
}
</script>

<style scoped>
.footer-bg {
    height: 140px;
    background-color: #EE6E73;
    background-image: linear-gradient(to right, #BF30AC 0%, #0F9D58 100%);
    opacity: 0.7;
    text-align: center;
    color: #FFF;
}
</style>