<template>
  <div>
    <v-row>
      <v-col style="z-index: 0;">
        <v-text-field label="用户名" :rules="rules" hide-details="auto"  v-model="user.nickname"></v-text-field>
        <v-text-field label="性别" v-model="this.genderText"></v-text-field>
        <v-text-field label="生日" v-model="user.birthday"></v-text-field>
        <v-text-field label="地址" v-model="user.address"></v-text-field>
      </v-col>
      <v-col style="z-index: 0;">
        <div>头像</div>
        <v-img :src="avatar"></v-img>
      </v-col>
    </v-row>
    
    <div class="text-center">
    <v-btn
      rounded
      color="primary"
      dark @click="alert"
    >
      修改
    </v-btn>
  </div>
  </div>
  
</template>

<script>
const genderArray = ['保密','男','女'];
import { mapState } from 'vuex';
  export default {
    data: () => ({
      rules: [
        value => !!value || 'Required.',
        value => (value && value.length >= 3) || 'Min 3 characters',
      ]
    }),
    methods: {
      alert() {
        alert('this.gender');
      }
    },
    computed: {
			...mapState({
        loginStatus: state => state.loginStatus,
				user: state => state.user
			}),
			genderText() {
				return genderArray[this.user.gender];
      },
      //用户头像
			avatar() {
				return this.user.avatar ? this.user.avatar : '/static/defaul.jpg';
      }
		}
  }
</script>

<style>

</style>