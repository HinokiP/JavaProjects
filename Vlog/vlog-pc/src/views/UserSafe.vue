<template>
  <v-row justify="center">
    <v-expansion-panels accordion>
      <v-expansion-panel
        v-for="(item,i) in 1"
        :key="i"
      >
        <v-expansion-panel-header>实名认证</v-expansion-panel-header>
        <v-expansion-panel-content>
            <v-col>
                未完成实名认证
            </v-col>
            <v-col>
                <v-btn text color="primary">实名认证</v-btn>
            </v-col>
        </v-expansion-panel-content>
      </v-expansion-panel>

      <v-expansion-panel
        v-for="(item,i) in 1"
        :key="i"
      >
        <v-expansion-panel-header>绑定新浪微博</v-expansion-panel-header>
        <v-expansion-panel-content>
            <v-col>
                未绑定微博账号
            </v-col>
            <v-col>
                <v-btn text color="primary">绑定微博</v-btn>
            </v-col>
        </v-expansion-panel-content>
      </v-expansion-panel>
      
      <v-expansion-panel
        v-for="(item,i) in 1"
        :key="i"
      >
        <v-expansion-panel-header>设置密码</v-expansion-panel-header>
        <v-expansion-panel-content>
            <v-col>
                已设置
            </v-col>
            <v-col>
                <v-btn text color="primary">设置密码</v-btn>
            </v-col>
        </v-expansion-panel-content>
      </v-expansion-panel>

      <v-expansion-panel
        v-for="(item,i) in 1"
        :key="i"
      >
        <v-expansion-panel-header>绑定手机</v-expansion-panel-header>
        <v-expansion-panel-content>
            <v-col>
                已绑定
            </v-col>
            <v-col>
                <v-btn text color="primary">更换手机</v-btn>
            </v-col>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
  </v-row>
  
</template>

<script>
export default {

}
</script>

<style>

</style>