<template>
	<view>
		<input type="text" placeholder="输入新密码" class="p-3 uni-input" v-model="newpassword" />
		<input type="text" placeholder="输入确认密码" class="p-3 uni-input" v-model="renewpassword" />
		<view class="py-2 px-3">
			<button class="bg-main text-white mt-2"
				 style="border-radius: 50rpx; border: 0;"
				 type="primary"
				 :disabled="disabled"
				 :class="disabled ? 'bg-main-disabled' : ''"
				 @click="submit">
				 设置
			</button>
		</view>
	</view>
</template>

<script>
	import { mapState } from 'vuex';
	export default {
		data() {
			return {
				newpassword:'',
				renewpassword:'',
			};
		},
		computed: {
			...mapState({
				user: state => state.user
			}),
			disabled() {
				return this.newpassword == '' || this.renewpassword == '';
			}
		},
		methods: {
			//验证
			check(){
				if(this.newpassword !== this.renewpassword) {
					uni.showToast({
						title: '两次密码不一致',
						icon: 'none'
					});
					return false;
				}
				return true;
			},
			submit() {
				if(!this.check()) {
					return;
				}
			}
		}
	}
</script>

<style>

</style>
