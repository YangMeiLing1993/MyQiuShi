/**
 * 
 */
package demo2.com.qf.com.myqiushi.common;


/**
 */
public class Uris {

	// 基本URI
	public static final String BASE_URI = "http://circle.qiushibaike.com/";

	// 广告URI
	// public static final StringBuffer ADV_URI = new StringBuffer(BASE_URI)
	// .append("getFullScreenPicAndroid?mid=a4f806da2fafa2454af6b73632d63183de70ad55&devid=99000535591806&mac=64%253A09%253A80%253AF7%253AF9%253A81&qqnetwork=wifi&store=826&screen_height=1920&Cookie=%20lskey%3D%3B%20luin%3D%3B%20skey%3D%3B%20uin%3D%3B%20logintype%3D0%20&apptype=android&hw=Xiaomi_MI3C&appver=23_android_5.0.0&uid=86e96dd47cae7f64&screen_width=1080&qn-sig=378ab6266bc7070040d8e27b0e391fc1&qn-rid=1155216174&imsi=460030966430814");

	// 隔壁
	public static final StringBuffer TAG_GEBI_FRIENDS = new StringBuffer(BASE_URI)
			.append("article/nearby/list?page=1&latitude=40.037207&longitude=116.370047&count=30&rqcnt=70&r=64896f1d1467972574150");

	// 视频
	public static final StringBuffer TAG_VIDEO_FRIENDS = new StringBuffer(BASE_URI)
			.append("article/video/list?page=1&latitude=40.037202&longitude=116.370046&rqcnt=75&r=64896f1d1467972699848"
					+ System.currentTimeMillis()
					/ 1000);

	// 话题
	public static final StringBuffer TAG_HUATI_FRIENDS = new StringBuffer(BASE_URI)
			.append("article/topic/top?page=1&count=20&rqcnt=82&r=64896f1d1467972762989");
}
