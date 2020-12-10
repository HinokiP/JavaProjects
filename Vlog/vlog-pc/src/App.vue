<template>
  <v-app>
    <v-container>
      <router-view />
    </v-container>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  components: {
  },

  data: () => ({
    //
  })
}
</script>

<style lang="scss">
.move {
  animation-duration: 0.6s;
  animation-delay:0.2s;
}
</style>