package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import com.fastwheel.fastwheelbackend.model.MyCategory;

public interface CategoryDAO {
	public boolean CreateCategory(MyCategory category);
	public boolean UpdateCategory(MyCategory category);
	public boolean DeleteCategory(String Category_Name);
	public List<MyCategory> ViewAllCategory();
	MyCategory ViewOneCategory(String CategoryName);


}
