package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.azhuoinfo.cqurity.R;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;
import mobi.cangol.mobile.logging.Log;
import mobi.cangol.mobile.utils.UrlUtils;
/**
 * Created by weixuewu on 15/9/22.
 */
public class WebViewFragment extends BaseContentFragment {
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private String mUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    protected void findViews(View view) {
        mWebView = (WebView) this.findViewById(R.id.webview);
        mProgressBar = (ProgressBar) this.findViewById(R.id.progressbar);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        Bundle args = this.getArguments();
        if (args != null && args.containsKey("url")) {
            mUrl = args.getString("url");
            this.setTitle(args.getString("title"));
        }

        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().supportZoom();
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("url:" + url);
                if (UrlUtils.isUrl(url)) {
                    mProgressBar.setProgress(0);
                    view.loadUrl(url);
                }
                return true;
            }

        });
        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mWebView.loadUrl(mUrl);
    }

    @Override
    public boolean onBackPressed() {
        WebBackForwardList history = mWebView.copyBackForwardList();
        if (history.getSize() > 0 && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onBackPressed();
    }

    @Override
    protected FragmentInfo getNavigtionUpToFragment() {
        return null;
    }


    @Override
    public boolean isCleanStack() {
        return false;
    }

}

