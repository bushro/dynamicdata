package com.bushro.service;

import java.util.List;

/**
 * @author BushRo
 * @Description: TOTO
 * @date 2019-09-30
 */
public interface UserService {
    //主库
    List getUserMaster();
    //从库
    List getUserSlave();
}
