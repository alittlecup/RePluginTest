package com.example.hbl.replugintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        if(BuildConfig.FLAVOR.equals("plugin")){
            textView.setText("这是个插件Apk");
            return;
        }
//        ImageView imageView = findViewById(R.id.imageViewIcon);
//        findViewById(R.id.btnPlugin1).setOnClickListener(view->{
//            RePlugin.startActivity(MainActivity.this,
//                    RePlugin.createIntent("com.qihoo360.replugin.sample.demo1",
//                            "com.qihoo360.replugin.sample.demo1.MainActivity"));
//        });
//        findViewById(R.id.btnPlugin2).setOnClickListener(view->{
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName("demo1","com.qihoo360.replugin.sample.demo1.activity.for_result.ForResultActivity"));
//            RePlugin.startActivityForResult(MainActivity.this,intent,REQUEST_CODE_DEMO1);
//        });
//        findViewById(R.id.btnPluginOutside).setOnClickListener(view->{
//            if(RePlugin.isPluginInstalled("demo3")){
//                RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("demo3",
//                        "com.qihoo360.replugin.sample.demo3.MainActivity"));
//
//            }else{
//                toast("还没有安装demo3");
//            }
//        });
//        findViewById(R.id.btnPluginOut2).setOnClickListener(view->{
//            ProgressDialog show = ProgressDialog.show(MainActivity.this, null, "安装中。。。。" );
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    simulateInstallExternalPlugin();
//                    show.dismiss();
//                }
//            },1000);
//        });
//        textView.setText(R.string.hoststring);
    }
    private static final int REQUEST_CODE_DEMO1 = 0x011;
    private static final int RESULT_CODE_DEMO1 = 0x012;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_DEMO1 && resultCode == RESULT_CODE_DEMO1) {
            Toast.makeText(this, data.getStringExtra("data"), Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 模拟安装或升级（覆盖安装）外置插件
     * 注意：为方便演示，外置插件临时放置到Host的assets/external目录下，具体说明见README</p>
     */
//    private void simulateInstallExternalPlugin() {
//        String demo3Apk= "demo3.apk";
//        String demo3apkPath = "external" + File.separator + demo3Apk;
//
//        // 文件是否已经存在？直接删除重来
//        String pluginFilePath = getFilesDir().getAbsolutePath() + File.separator + demo3Apk;
//        File pluginFile = new File(pluginFilePath);
//        if (pluginFile.exists()) {
//            FileUtils.deleteQuietly(pluginFile);
//        }
//
//        // 开始复制
//        copyAssetsFileToAppFiles(demo3apkPath, demo3Apk);
//        PluginInfo info = null;
//        if (pluginFile.exists()) {
//            info = RePlugin.install(pluginFilePath);
//        }
//
//        if (info != null) {
//            RePlugin.startActivity(MainActivity.this, RePlugin.createIntent(info.getName(), "com.qihoo360.replugin.sample.demo3.MainActivity"));
//        } else {
//            Toast.makeText(MainActivity.this, "install external plugin failed", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /**
//     * 从assets目录中复制某文件内容
//     *  @param  assetFileName assets目录下的Apk源文件路径
//     *  @param  newFileName 复制到/data/data/package_name/files/目录下文件名
//     */
//    private void copyAssetsFileToAppFiles(String assetFileName, String newFileName) {
//        InputStream is = null;
//        FileOutputStream fos = null;
//        int buffsize = 1024;
//
//        try {
//            is = this.getAssets().open(assetFileName);
//            fos = this.openFileOutput(newFileName, Context.MODE_PRIVATE);
//            int byteCount = 0;
//            byte[] buffer = new byte[buffsize];
//            while((byteCount = is.read(buffer)) != -1) {
//                fos.write(buffer, 0, byteCount);
//            }
//            fos.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//                fos.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
