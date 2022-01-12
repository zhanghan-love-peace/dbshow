package com.imjava.dbshow.dbutils;

public class TestManageIndex {
    public static void main(String[] args) {
        TestAddIndex();
        TestDeleteIndex();
        TestModifyIndex();
    }

    public static void TestAddIndex() {
        System.out.println(ManageIndex.AddIndex(1, "first manual first index", -1));
        System.out.println(ManageIndex.AddIndex(1, "second manual first index", -1));

        System.out.println(ManageIndex.AddIndex(2, "first manual second index", 1));
        System.out.println(ManageIndex.AddIndex(3, "first manual third index", 1));
    }

    public static void TestDeleteIndex() {
        System.out.println(ManageIndex.deleteIndex(1, 7));
        System.out.println(ManageIndex.deleteIndex(2, 4));
        System.out.println(ManageIndex.deleteIndex(3, 3));
    }

    public static void TestModifyIndex() {
        System.out.println(ManageIndex.modifyIndex(1, 1, "修改一级指标"));
        System.out.println(ManageIndex.modifyIndex(2, 2, "修改二级指标"));
        System.out.println(ManageIndex.modifyIndex(3, 1, "修改三级指标"));
    }
}
