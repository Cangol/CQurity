package com.azhuoinfo.cqurity.api.task;


public interface OnDataLoader<T>{

	void onStart();

	void onSuccess(int totalPage,T t);

	void onFailure(String errorCode,String errorResponse) ;
	 
}
