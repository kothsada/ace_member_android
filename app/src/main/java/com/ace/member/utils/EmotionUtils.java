package com.ace.member.utils;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmotionUtils {

	/**
	 * key-表情文字;
	 * value-表情图片资源
	 */
	public static LinkedHashMap<String, Integer> EMOTION_STATIC_MAP;


	static {
		EMOTION_STATIC_MAP = new LinkedHashMap<>();

//		EMOTION_STATIC_MAP.put("[微笑]", R.drawable.emotion_weixiao);
//		EMOTION_STATIC_MAP.put("[撇嘴]", R.drawable.emotion_biezui);
//		EMOTION_STATIC_MAP.put("[色]", R.drawable.emotion_se);
//		EMOTION_STATIC_MAP.put("[发呆]", R.drawable.emotion_fadai);
//		EMOTION_STATIC_MAP.put("[得意]", R.drawable.emotion_deyi);
//		EMOTION_STATIC_MAP.put("[流泪]", R.drawable.emotion_liulei);
//		EMOTION_STATIC_MAP.put("[害羞]", R.drawable.emotion_haixiu);
//		EMOTION_STATIC_MAP.put("[闭嘴]", R.drawable.emotion_bizui);
//		EMOTION_STATIC_MAP.put("[睡]", R.drawable.emotion_shui);
//		EMOTION_STATIC_MAP.put("[大哭]", R.drawable.emotion_daku);
//		EMOTION_STATIC_MAP.put("[尴尬]", R.drawable.emotion_ganga);
//		EMOTION_STATIC_MAP.put("[发怒]", R.drawable.emotion_fanu);
//		EMOTION_STATIC_MAP.put("[调皮]", R.drawable.emotion_tiaopi);
//		EMOTION_STATIC_MAP.put("[呲牙]", R.drawable.emotion_ciya);
//		EMOTION_STATIC_MAP.put("[惊讶]", R.drawable.emotion_jingya);
//		EMOTION_STATIC_MAP.put("[难过]", R.drawable.emotion_nanguo);
//		EMOTION_STATIC_MAP.put("[酷]", R.drawable.emotion_ku);
//		EMOTION_STATIC_MAP.put("[冷汗]", R.drawable.emotion_lenghan);
//		EMOTION_STATIC_MAP.put("[抓狂]", R.drawable.emotion_zhuakuang);
//		EMOTION_STATIC_MAP.put("[吐]", R.drawable.emotion_tu);
//		EMOTION_STATIC_MAP.put("[偷笑]", R.drawable.emotion_touxiao);
//		EMOTION_STATIC_MAP.put("[可爱]", R.drawable.emotion_keai);
//		EMOTION_STATIC_MAP.put("[白眼]", R.drawable.emotion_baiyan);
//		EMOTION_STATIC_MAP.put("[傲慢]", R.drawable.emotion_aoman);
//		EMOTION_STATIC_MAP.put("[饥饿]", R.drawable.emotion_jie);
//		EMOTION_STATIC_MAP.put("[困]", R.drawable.emotion_kun);
//		EMOTION_STATIC_MAP.put("[惊恐]", R.drawable.emotion_jingkong);
//		EMOTION_STATIC_MAP.put("[流汗]", R.drawable.emotion_liuhan);
//		EMOTION_STATIC_MAP.put("[憨笑]", R.drawable.emotion_hanxiao);
//		EMOTION_STATIC_MAP.put("[大兵]", R.drawable.emotion_dabing);
//		EMOTION_STATIC_MAP.put("[奋斗]", R.drawable.emotion_fendou);
//		EMOTION_STATIC_MAP.put("[咒骂]", R.drawable.emotion_zouma);
//		EMOTION_STATIC_MAP.put("[疑问]", R.drawable.emotion_yiwen);
//		EMOTION_STATIC_MAP.put("[嘘]", R.drawable.emotion_xu);
//		EMOTION_STATIC_MAP.put("[晕]", R.drawable.emotion_yun);
//		EMOTION_STATIC_MAP.put("[折磨]", R.drawable.emotion_fakuang);
//		EMOTION_STATIC_MAP.put("[衰]", R.drawable.emotion_shuai);
//		EMOTION_STATIC_MAP.put("[骷髅]", R.drawable.emotion_kulou);
//		EMOTION_STATIC_MAP.put("[敲打]", R.drawable.emotion_qiaoda);
//		EMOTION_STATIC_MAP.put("[再见]", R.drawable.emotion_zaijian);
//		EMOTION_STATIC_MAP.put("[擦汗]", R.drawable.emotion_cahan);
//		EMOTION_STATIC_MAP.put("[抠鼻]", R.drawable.emotion_koubi);
//		EMOTION_STATIC_MAP.put("[鼓掌]", R.drawable.emotion_guzhang);
//		EMOTION_STATIC_MAP.put("[糗大了]", R.drawable.emotion_qiudale);
//		EMOTION_STATIC_MAP.put("[坏笑]", R.drawable.emotion_huaixiao);
//		EMOTION_STATIC_MAP.put("[左哼哼]", R.drawable.emotion_zuohengheng);
//		EMOTION_STATIC_MAP.put("[右哼哼]", R.drawable.emotion_youhengheng);
//		EMOTION_STATIC_MAP.put("[哈欠]", R.drawable.emotion_haqian);
//		EMOTION_STATIC_MAP.put("[鄙视]", R.drawable.emotion_bishi);
//		EMOTION_STATIC_MAP.put("[委屈]", R.drawable.emotion_weiqu);
//		EMOTION_STATIC_MAP.put("[快哭了]", R.drawable.emotion_kuaikule);
//		EMOTION_STATIC_MAP.put("[阴险]", R.drawable.emotion_yingxian);
//		EMOTION_STATIC_MAP.put("[亲亲]", R.drawable.emotion_qinqin);
//		EMOTION_STATIC_MAP.put("[吓]", R.drawable.emotion_xia);
//		EMOTION_STATIC_MAP.put("[可怜]", R.drawable.emotion_kelian);
//		EMOTION_STATIC_MAP.put("[菜刀]", R.drawable.emotion_caidao);
//		EMOTION_STATIC_MAP.put("[西瓜]", R.drawable.emotion_xigua);
//		EMOTION_STATIC_MAP.put("[啤酒]", R.drawable.emotion_pijiu);
//		EMOTION_STATIC_MAP.put("[篮球]", R.drawable.emotion_lanqiu);
//		EMOTION_STATIC_MAP.put("[乒乓]", R.drawable.emotion_pingpang);
//		EMOTION_STATIC_MAP.put("[咖啡]", R.drawable.emotion_kafei);
//		EMOTION_STATIC_MAP.put("[饭]", R.drawable.emotion_fan);
//		EMOTION_STATIC_MAP.put("[猪头]", R.drawable.emotion_zhutou);
//		EMOTION_STATIC_MAP.put("[玫瑰]", R.drawable.emotion_meigui);
//		EMOTION_STATIC_MAP.put("[凋谢]", R.drawable.emotion_diaoxie);
//		EMOTION_STATIC_MAP.put("[示爱]", R.drawable.emotion_shiai);
//		EMOTION_STATIC_MAP.put("[爱心]", R.drawable.emotion_aixin);
//		EMOTION_STATIC_MAP.put("[心碎]", R.drawable.emotion_xinsui);
//		EMOTION_STATIC_MAP.put("[蛋糕]", R.drawable.emotion_dangao);
//		EMOTION_STATIC_MAP.put("[闪电]", R.drawable.emotion_shandian);
//		EMOTION_STATIC_MAP.put("[炸弹]", R.drawable.emotion_zhadan);
//		EMOTION_STATIC_MAP.put("[刀]", R.drawable.emotion_dao);
//		EMOTION_STATIC_MAP.put("[足球]", R.drawable.emotion_zhuqiu);
//		EMOTION_STATIC_MAP.put("[瓢虫]", R.drawable.emotion_pachong);
//		EMOTION_STATIC_MAP.put("[便便]", R.drawable.emotion_bianbian);
//		EMOTION_STATIC_MAP.put("[月亮]", R.drawable.emotion_yueliang);
//		EMOTION_STATIC_MAP.put("[太阳]", R.drawable.emotion_taiyang);
//		EMOTION_STATIC_MAP.put("[礼物]", R.drawable.emotion_liwu);
//		EMOTION_STATIC_MAP.put("[拥抱]", R.drawable.emotion_baobao);
//		EMOTION_STATIC_MAP.put("[强]", R.drawable.emotion_qiang);
//		EMOTION_STATIC_MAP.put("[弱]", R.drawable.emotion_ruo);
//		EMOTION_STATIC_MAP.put("[握手]", R.drawable.emotion_woshou);
//		EMOTION_STATIC_MAP.put("[胜利]", R.drawable.emotion_shengli);
//		EMOTION_STATIC_MAP.put("[抱拳]", R.drawable.emotion_baoquan);
//		EMOTION_STATIC_MAP.put("[勾引]", R.drawable.emotion_gouying);
//		EMOTION_STATIC_MAP.put("[拳头]", R.drawable.emotion_quantou);
//		EMOTION_STATIC_MAP.put("[差劲]", R.drawable.emotion_chajing);
//		EMOTION_STATIC_MAP.put("[爱你]", R.drawable.emotion_aini);
//		EMOTION_STATIC_MAP.put("[NO]", R.drawable.emotion_no);
//		EMOTION_STATIC_MAP.put("[OK]", R.drawable.emotion_ok);
//		EMOTION_STATIC_MAP.put("[爱情]", R.drawable.emotion_aiqing);
//		EMOTION_STATIC_MAP.put("[飞吻]", R.drawable.emotion_feiwen);
//		EMOTION_STATIC_MAP.put("[跳跳]", R.drawable.emotion_tiaotiao);
//		EMOTION_STATIC_MAP.put("[发抖]", R.drawable.emotion_fadou);
//		EMOTION_STATIC_MAP.put("[怄火]", R.drawable.emotion_ouhuo);
//		EMOTION_STATIC_MAP.put("[转圈]", R.drawable.emotion_zhuanquan);
//		EMOTION_STATIC_MAP.put("[磕头]", R.drawable.emotion_ketou);
//		EMOTION_STATIC_MAP.put("[回头]", R.drawable.emotion_huitou);
//		EMOTION_STATIC_MAP.put("[跳绳]", R.drawable.emotion_tiaosheng);
//		EMOTION_STATIC_MAP.put("[挥手]", R.drawable.emotion_huishou);
//		EMOTION_STATIC_MAP.put("[激动]", R.drawable.emotion_jidong);
//		EMOTION_STATIC_MAP.put("[街舞]", R.drawable.emotion_jiewu);
//		EMOTION_STATIC_MAP.put("[献吻]", R.drawable.emotion_xianwen);
//		EMOTION_STATIC_MAP.put("[左太极]", R.drawable.emotion_zuotaiji);
//		EMOTION_STATIC_MAP.put("[右太极]", R.drawable.emotion_youtaiji);
//		EMOTION_STATIC_MAP.put("[双喜]", R.drawable.emotion_shuangxi);
//		EMOTION_STATIC_MAP.put("[鞭炮]", R.drawable.emotion_bianpao);
//		EMOTION_STATIC_MAP.put("[灯笼]", R.drawable.emotion_denglong);
//		EMOTION_STATIC_MAP.put("[发财]", R.drawable.emotion_facai);
//		EMOTION_STATIC_MAP.put("[K歌]", R.drawable.emotion_kge);
//		EMOTION_STATIC_MAP.put("[购物]", R.drawable.emotion_gouwu);
//		EMOTION_STATIC_MAP.put("[邮件]", R.drawable.emotion_youjian);
//		EMOTION_STATIC_MAP.put("[帅]", R.drawable.emotion_dashuai);
//		EMOTION_STATIC_MAP.put("[喝彩]", R.drawable.emotion_hecai);
//		EMOTION_STATIC_MAP.put("[祈祷]", R.drawable.emotion_qidao);
//		EMOTION_STATIC_MAP.put("[爆筋]", R.drawable.emotion_baojing);
//		EMOTION_STATIC_MAP.put("[棒棒糖]", R.drawable.emotion_bangbangtang);
//		EMOTION_STATIC_MAP.put("[喝奶]", R.drawable.emotion_henai);
//		EMOTION_STATIC_MAP.put("[下面]", R.drawable.emotion_xiamian);
//		EMOTION_STATIC_MAP.put("[香蕉]", R.drawable.emotion_xiangjiao);
//		EMOTION_STATIC_MAP.put("[飞机]", R.drawable.emotion_feiji);
//		EMOTION_STATIC_MAP.put("[开车]", R.drawable.emotion_kaiche);
//		EMOTION_STATIC_MAP.put("[左车头]", R.drawable.emotion_zuochetou);
//		EMOTION_STATIC_MAP.put("[车厢]", R.drawable.emotion_chexiang);
//		EMOTION_STATIC_MAP.put("[右车头]", R.drawable.emotion_youchexiang);
//		EMOTION_STATIC_MAP.put("[多云]", R.drawable.emotion_duoyun);
//		EMOTION_STATIC_MAP.put("[下雨]", R.drawable.emotion_xiayu);
//		EMOTION_STATIC_MAP.put("[钞票]", R.drawable.emotion_chaopiao);
//		EMOTION_STATIC_MAP.put("[熊猫]", R.drawable.emotion_xiongmao);
//		EMOTION_STATIC_MAP.put("[灯泡]", R.drawable.emotion_dengpao);
//		EMOTION_STATIC_MAP.put("[风车]", R.drawable.emotion_fengche);
//		EMOTION_STATIC_MAP.put("[闹钟]", R.drawable.emotion_naozhong);
//		EMOTION_STATIC_MAP.put("[打伞]", R.drawable.emotion_dashan);
//		EMOTION_STATIC_MAP.put("[彩球]", R.drawable.emotion_caiqiu);
//		EMOTION_STATIC_MAP.put("[钻戒]", R.drawable.emotion_zhuanjie);
//		EMOTION_STATIC_MAP.put("[沙发]", R.drawable.emotion_shafa);
//		EMOTION_STATIC_MAP.put("[纸巾]", R.drawable.emotion_zhijing);
//		EMOTION_STATIC_MAP.put("[药]", R.drawable.emotion_yao);
//		EMOTION_STATIC_MAP.put("[手枪]", R.drawable.emotion_shouqiang);
//		EMOTION_STATIC_MAP.put("[青蛙]", R.drawable.emotion_qingwa);
	}

	/**
	 * 文本中的emojb字符处理为表情图片
	 *
	 * @param context
	 * @param tv
	 * @param source
	 * @return
	 */
	public static SpannableString getEmotionContent(final Context context, final TextView tv, String source) {
		if (TextUtils.isEmpty(source)) return null;
		SpannableString spannableString = new SpannableString(source);
		Resources res = context.getResources();

		String regexEmotion = "\\[([\u4e00-\u9fa5\\w])+\\]";
		Pattern patternEmotion = Pattern.compile(regexEmotion);
		Matcher matcherEmotion = patternEmotion.matcher(spannableString);

		while (matcherEmotion.find()) {
			// 获取匹配到的具体字符
			String key = matcherEmotion.group();
			// 匹配字符串的开始位置
			int start = matcherEmotion.start();
			// 利用表情名字获取到对应的图片
			Integer imgRes = EmotionUtils.EMOTION_STATIC_MAP.get(key);
			if (imgRes != null) {
				// 压缩表情图片
				int size = (int) tv.getTextSize() * 13 / 10;
				Bitmap bitmap = BitmapFactory.decodeResource(res, imgRes);
				Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);

				ImageSpan span = new ImageSpan(context, scaleBitmap);
				spannableString.setSpan(span, start, start + key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return spannableString;
	}
}