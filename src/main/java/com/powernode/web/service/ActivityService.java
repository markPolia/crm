package com.powernode.web.service;

import com.powernode.web.domain.Activity;

public interface ActivityService {
    /**
     *  添加市场活动
     * @param activity 市场活动
     * @return 添加是否成功
     */
    boolean saveActivity(Activity activity);
}
