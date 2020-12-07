<template>
	<view>
		<view class="flex justify-center pt-5" >
			<image src="/static/common/nothing.png" mode="" style="border-radius: 130rpx;width: 400rpx;height: 400rpx;"></image>
		</view>
		<input type="text" placeholder="version 1.0.0" class="font-small text-center pt-3" />
		<uniListItem title="新版本检测" class="pl-3"></uniListItem>
		<uniListItem title="社区用户协议" class="pl-3"></uniListItem>
	</view>
</template>

<script>
	import uniListItem from '@/components/uni-ui/uni-list-item/uni-list-item.vue';
	export default {
		components: {
			uniListItem
		},
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
