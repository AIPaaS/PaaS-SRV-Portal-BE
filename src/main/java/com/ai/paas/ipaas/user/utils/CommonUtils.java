package com.ai.paas.ipaas.user.utils;

import java.io.File;

public class CommonUtils {

	public static String getFilePath(String pathname) {
		// file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		path = path.replace("file:", ""); // 去掉file:
		path = path.replace("classes/", ""); // 去掉class\
		path = path.substring(1); // 去掉第一个\,如 \D:\JavaWeb...
		path += pathname + "/";
		// System.out.println(path);
		return "/" + path;
	}

	/**
	 * 在windows 下 获取目录的路径
	 * 
	 * @param pathname
	 *            根目录的下路径
	 * @return 绝对路径
	 */
	public static String getFilePathForWindows(String pathname) {
		// file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("/").getPath();
		path += pathname + "/";
		// System.out.println(path);
		return path;
	}

	/**
	 * 获取项目根目录 暂时认为此方法不用考虑Linux和Windows这样就可以忽略"../"这种写法带来的问题。
	 * 
	 * @return
	 */
	public static String getRootPath() {
		String path = CommonUtils.class.getClass().getClassLoader()
				.getResource("").getPath();
		return path;
	}

	/**
	 * 注意： 创建项目ID的目录 路径尚未明确传到哪里 。 uploads中有文件删除 待更改。
	 * 暂时创建到WEB-INF/project/id的文件夹中 具体待定
	 * 
	 * @param id
	 * @return
	 */
	public static boolean createFile(int id) {
		String rootPath = CommonUtils.getRootPath();
		String warpath = rootPath + "WEB-INF/" + "project/" + id + "/war";
		String jarpath = rootPath + "WEB-INF/" + "project/" + id + "/jar";
		try {
			File file = new File(warpath);
			file.mkdirs();
			File file2 = new File(jarpath);
			file2.mkdirs();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
