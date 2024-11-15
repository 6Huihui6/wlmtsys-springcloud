package com.hui.obs.service.domain;

import com.obs.services.ObsClient;

public class OBS {
    static String ak = "15VVYEBYOTBW0MXZPPRL";
    static String sk = "HvZKFxJkDUdd3FN5Agg0TR8npTyUn3KimnXmHHrN";
    static String endPoint = "obs.cn-south-1.myhuaweicloud.com";
    public static ObsClient client = new ObsClient(ak, sk,endPoint);
}
