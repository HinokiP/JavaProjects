<template>
  <v-app id="app">
    <v-main>
      <router-view />
    </v-main>
    <v-btn class="mx-2" fab dark color="red" fixed bottom right v-if="show" @click="backToTop">
      <v-icon dark>
        mdi-arrow-up
      </v-icon>
    </v-btn>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    show: false
  }),
  mounted() {
    //等到页面产生滚动才执行监听
    this.$nextTick(function() {
      window.addEventListener('scroll', this.scrollToTop)
    })
  },
  methods: {
    backToTop() {
      //加定时器，平滑过渡回到顶部
      let timer = setInterval(() => {
        let ispeed = Math.floor(-this.scrollTop / 5)
        document.documentElement.scrollTop = document.body.scrollTop = this.scrollTop + ispeed
        if (this.scrollTop === 0) {
          clearInterval(timer)
        }
      }, 16)
    },
    // 计算距离顶部的高度，当高度大于400显示回顶部图标，小于400隐藏
    scrollToTop() {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      this.scrollTop = scrollTop
      this.show = scrollTop > 400
    }
  }
}
</script>

<style lang="scss">
.move {
  animation-duration: 0.6s;
  animation-delay:0.2s;
}
a:link {
  text-decoration: none;
}
.bg-color {
  background-image: linear-gradient(to right, #BF30AC 0%, #0F9D58 100%);
  opacity: 0.7;
}
</style>