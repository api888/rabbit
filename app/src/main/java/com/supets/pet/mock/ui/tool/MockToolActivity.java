package com.supets.pet.mock.ui.tool;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.supets.commons.widget.CommonHeader;
import com.supets.pet.jsonview.JSONEditView;
import com.supets.pet.mock.config.Config;
import com.supets.pet.mock.dao.EmailDataDB;
import com.supets.pet.mock.utils.MailUtil;
import com.supets.pet.mockui.R;

/**
 * supets_shopmail
 *
 * @user lihongjiang
 * @description
 * @date 2017/6/21
 * @updatetime 2017/6/21
 */

public class MockToolActivity extends AppCompatActivity {


    private CommonHeader mCommonHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocktool_jsonedit);

        mCommonHeader = findViewById(R.id.header);
        mCommonHeader.getLeftButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mCommonHeader.getTitleTextView().setText(R.string.jsonedit);

        JSONEditView jsonEditView = findViewById(R.id.jsonEditView);
        String json = getIntent().getStringExtra("json");

        if (!TextUtils.isEmpty(json)) {
            try {
                jsonEditView.formatJson(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mCommonHeader.getRightButton().setText("邮件分享");
        mCommonHeader.getRightButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSendEmail();
            }
        });
    }


    private void doSendEmail() {
        String[] list = EmailDataDB.getEmailList();

        final String[] finalList = list;
        new AlertDialog.Builder(this)
                .setTitle(R.string.emaillist)
                .setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MailUtil.setUser(Config.getEmailName());
                        MailUtil.setPassword(Config.getEmailPass());
                        MailUtil.sendEmail(Config.getEmailName(), finalList[which],
                                getString(R.string.crash_title),
                                getIntent().getStringExtra("json"));
                    }
                }).show();
    }
}
