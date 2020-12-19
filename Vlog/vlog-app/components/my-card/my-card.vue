<template>
	<view class="my-card" @click="open">
		<view class="thumb">
			<image :src="article.cover" class="img" mode="aspectFill"></image>
			<view class="category">{{ article.category }}</view>
			<view class="publishDate">{{ article.publishDate }}</view>
		</view>
		<view class="detail">
			<view class="mid">
				<view class="title">{{ article.title }}</view>
				<view class="summary">
					{{ article.summary.length > 30 ? article.summary.substring(0, 30) : article.summary }}
				</view>
				<view v-for="(tag, index) in article.tagList" :key="index" class="tagName">{{ tag.tagName }}</view>
			</view>
			<view class="right"></view>
		</view>
	</view>
</template>

<script>
	export default {
		name: 'MyCard',
		props: ['article'],	//通过props传值，父组件中将article传过来
		computed: {
			//计算属性，文章摘要的长度超出，就用...代替
			summary() {
				let summary = this.article.summary;
				if (summary && summary.length > 30) {
					summary = summary.substring(0, 30) + '...';
				}
				return summary;
			}
		},
		methods: {
			open() {
				//在子组件my-card.vue中将点击事件传回父组件index.vue
				this.$emit('open');
			}
		}
	}
</script>

<style lang="scss" scoped>
.my-card {
	padding: 20rpx 20rpx;
	border-bottom: 1px solid #ddd;
	display: flex;
	background-color: #fff;
	font-size: 14px;
	.thumb {
		width: 200rpx;
		height: 220rpx;
		position: relative;
		.img {
			width: 150rpx;
			height: 150rpx;
			border-radius: 10%;
			position: absolute;
			top: 10rpx;
			left: 10rpx;
		}
		.category {
			color: #754a8f;
			padding: 2px 2px;
			position: absolute;
			bottom: 0;
			left: 25rpx;
		}
		.publishDate {
			padding: 2px 2px;
			position: absolute;
			top: 200rpx;
			left: 5rpx;
		}
	}	
	.detail {
		padding-left: 20px;
		word-wrap: break-word;
		width: 550rpx;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		.mid {
			.title {
				font-weight: bold;
			}
			.tagName {
				display: inline-block;
				margin-right: 10px;
				background-color: #0F6674;
				color: #fff;
				padding: 0 10rpx;
				border: 1px slid #0F6674;
				border-radius: 20rpx;
			}
		}
		.right {
			width: 70px;
			text-align: right;
		}
	}
}

</style>
