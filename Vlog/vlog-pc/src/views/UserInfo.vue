<template>
  <div>
    <v-text-field
      label="用户名"
      :rules="rules"
      hide-details="auto"
    ></v-text-field>
    <v-text-field label="邮箱"></v-text-field>
    <v-text-field label="手机号"></v-text-field>
    <div class="text-center">
    <v-btn
      rounded
      color="primary"
      dark
    >
      Rounded Button
    </v-btn>
  </div>
  </div>
  
</template>

<script>
  export default {
    data: () => ({
      rules: [
        value => !!value || 'Required.',
        value => (value && value.length >= 3) || 'Min 3 characters',
      ],
    }),
  }
</script>

<style>

</style>