package com.example.team.wang.utils;

import android.content.Context;
import android.content.Intent;

import com.example.team.wang.activity.OnClassActivity;
import com.example.team.wang.engine.fragment.white_list.FragmentWhiteListModel;
import com.example.team.wang.entity.AppInfo;
import com.example.team.monitorlib.components.AppMonitor;

import java.util.ArrayList;

/**
 * Created by Ellly on 2018/3/11.
 */
public class PackageNameMonitor extends FragmentWhiteListModel {

    public PackageNameMonitor(){
        getMonitor().setDetectListener(new AppMonitor.DetectListener() {
            @Override
            public void afterDetect(Context context) {
                context.startActivity(new Intent(context, OnClassActivity.class));
            }
        });
    }

    public ArrayList<String> getPackageNames(){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<AppInfo> infos = getAppInfos();
        for(AppInfo info : infos){
            names.add(info.getAppPackageName());
        }
        return names;
    }

    public void startMonitor(){
        getMonitor().startMonitor(new ArrayList<String>());
    }

    public void stopMonitor(){
        getMonitor().stopMonitor();
    }

    public AppMonitor getMonitor(){
        return mMonitor;
    }

}