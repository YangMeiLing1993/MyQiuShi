package demo2.com.qf.com.myqiushi.friends.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import demo2.com.qf.com.myqiushi.R;

public class ShowActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);

//		WebView webView = (WebView) findViewById(R.id.webview);
//		WebSettings settings = webView.getSettings();
//		settings.setJavaScriptEnabled(true);
//		WebViewClient client = new WebViewClient();// 将浏览器嵌入到WebView控件中
//		webView.setWebViewClient(client);
//		webView.loadUrl(getIntent().getStringExtra("detailUrl"));
	}

}
