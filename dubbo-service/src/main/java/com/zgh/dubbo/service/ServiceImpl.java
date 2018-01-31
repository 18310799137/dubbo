package com.zgh.dubbo.service;

import com.zgh.dubbo.api.IService;

/**
 * api接口实现类，远程调用时，如果调用父类接口，则执行此实现类方法，并返回结果
 * 
 * @author FreeGuardian
 *
 */
public class ServiceImpl implements IService {

	public String hiService() {
		return " [Provider Return - hiService 8082]";
	}
}
