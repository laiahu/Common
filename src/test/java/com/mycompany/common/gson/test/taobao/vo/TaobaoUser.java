package com.mycompany.common.gson.test.taobao.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class TaobaoUser {

	@SerializedName("user_id")	 
	private Long userId;
	
	@SerializedName("uid")	 
	private String uid;
	
	@SerializedName("nick")	 
	private String nick;
	
	@SerializedName("sex")	
	private String sex; //m(男),f(女)
	
	@SerializedName("buyer_credit")	
	private UserCredit buyerCredit;
	
	@SerializedName("seller_credit")
	private UserCredit sellerCredit;
	
	@SerializedName("location")	
	private String location;
	
	@SerializedName("created")
	private String created; //date "2013-03-17 18:09:57"
	
	@SerializedName("last_visit")
	private String lastVisit; //date "2013-03-17 18:09:57"
	
	@SerializedName("birthday")	
	private String birthday; //date
	
	@SerializedName("type")	 
	private String type;
	
	@SerializedName("has_more_pic")	
	private boolean hasMorePic;
	
	@SerializedName("item_img_num")	
	private int itemImgNum; //可上传商品图片数量
	
	@SerializedName("item_img_size")
	private int itemImgSize; //单位 k
	
	@SerializedName("prop_img_num")	
	private int propImgNum;
	
	@SerializedName("prop_img_size")
	private int propImgSize;  //单位 k
	
	@SerializedName("auto_repost")	
	private String autoRepost;  //是否受限制。可选值:limited(受限制),unlimited(不受限)
	
	@SerializedName("promoted_type")
	private String promotedType;  //有无实名认证。可选值:authentication(实名认证),not authentication(没有认证)
	
	@SerializedName("status")
	private String status;
	
	@SerializedName("alipay_bind")
	private String alipayBind;
	
	@SerializedName("consumer_protection")	
	private boolean consumerProtection;
	
	@SerializedName("avatar")	 
	private String avatar;
	
	@SerializedName("liangpin")	 
	private boolean liangpin;
	
	@SerializedName("sign_food_seller_promise")
	private boolean signFoodSellerPromise;
	
	@SerializedName("has_shop")	
	private boolean hasShop;
	
	@SerializedName("is_lightning_consignment")
	private boolean lightningConsignment;  //is
	
	@SerializedName("has_sub_stock")	 	
	private boolean hasSubStock;
	
	@SerializedName("is_golden_seller")	  
	private boolean goldenSeller;  //is
	
	@SerializedName("vip_info")	
	private String vipInfo;
	
	@SerializedName("email")	   
	private String email;
	
	@SerializedName("magazine_subscribe")	
	private boolean magazineSubscribe;
	
	@SerializedName("vertical_market")	 
	private String verticalMarket;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserCredit getBuyerCredit() {
		return buyerCredit;
	}

	public void setBuyerCredit(UserCredit buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public UserCredit getSellerCredit() {
		return sellerCredit;
	}

	public void setSellerCredit(UserCredit sellerCredit) {
		this.sellerCredit = sellerCredit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHasMorePic() {
		return hasMorePic;
	}

	public void setHasMorePic(boolean hasMorePic) {
		this.hasMorePic = hasMorePic;
	}

	public int getItemImgNum() {
		return itemImgNum;
	}

	public void setItemImgNum(int itemImgNum) {
		this.itemImgNum = itemImgNum;
	}

	public int getItemImgSize() {
		return itemImgSize;
	}

	public void setItemImgSize(int itemImgSize) {
		this.itemImgSize = itemImgSize;
	}

	public int getPropImgNum() {
		return propImgNum;
	}

	public void setPropImgNum(int propImgNum) {
		this.propImgNum = propImgNum;
	}

	public int getPropImgSize() {
		return propImgSize;
	}

	public void setPropImgSize(int propImgSize) {
		this.propImgSize = propImgSize;
	}

	public String getAutoRepost() {
		return autoRepost;
	}

	public void setAutoRepost(String autoRepost) {
		this.autoRepost = autoRepost;
	}

	public String getPromotedType() {
		return promotedType;
	}

	public void setPromotedType(String promotedType) {
		this.promotedType = promotedType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAlipayBind() {
		return alipayBind;
	}

	public void setAlipayBind(String alipayBind) {
		this.alipayBind = alipayBind;
	}

	public boolean isConsumerProtection() {
		return consumerProtection;
	}

	public void setConsumerProtection(boolean consumerProtection) {
		this.consumerProtection = consumerProtection;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isLiangpin() {
		return liangpin;
	}

	public void setLiangpin(boolean liangpin) {
		this.liangpin = liangpin;
	}

	public boolean isSignFoodSellerPromise() {
		return signFoodSellerPromise;
	}

	public void setSignFoodSellerPromise(boolean signFoodSellerPromise) {
		this.signFoodSellerPromise = signFoodSellerPromise;
	}

	public boolean isHasShop() {
		return hasShop;
	}

	public void setHasShop(boolean hasShop) {
		this.hasShop = hasShop;
	}

	

	public boolean isHasSubStock() {
		return hasSubStock;
	}

	public void setHasSubStock(boolean hasSubStock) {
		this.hasSubStock = hasSubStock;
	}


	public boolean isLightningConsignment() {
		return lightningConsignment;
	}

	public void setLightningConsignment(boolean lightningConsignment) {
		this.lightningConsignment = lightningConsignment;
	}

	public boolean isGoldenSeller() {
		return goldenSeller;
	}

	public void setGoldenSeller(boolean goldenSeller) {
		this.goldenSeller = goldenSeller;
	}

	public String getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(String vipInfo) {
		this.vipInfo = vipInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMagazineSubscribe() {
		return magazineSubscribe;
	}

	public void setMagazineSubscribe(boolean magazineSubscribe) {
		this.magazineSubscribe = magazineSubscribe;
	}

	public String getVerticalMarket() {
		return verticalMarket;
	}

	public void setVerticalMarket(String verticalMarket) {
		this.verticalMarket = verticalMarket;
	}
	
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
