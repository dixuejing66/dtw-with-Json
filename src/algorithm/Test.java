package algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

//import algorithm.Point;

public class Test {

	// private Trajectory t1;
	// private Trajectory t2;

	public List<Trajectory> locations;

	public static void main(String[] args) throws Exception {
		DTW dtw = new DTW();
		Test test = new Test();
		File folder = new File("/dtw/Json");
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++) {
				for (int j = i + 1; j < files.length; j++) {
					if (files[i].isFile()) {
						if (files[i].getName().endsWith(".json")) {

							File file = new File(files[i].getName());
							File file2 = new File(files[j].getName());
							String str = test.readJsonFile(file);
							String str2 = test.readJsonFile(file2);
							test.test(str2);
							test.test(str);
							Point[] p1 = new Point[test.test(str).size()];
							Point[] p2 = new Point[test.test(str2).size()];
							for (int a = 0; a < test.test(str).size(); a++) {
								// System.out.println(test.test(str).get(i).getLatitude());

								// System.out.println(test.test(str).get(i).getLatitude());
								p1[a] = new Point();
								// System.out.println(p1.length);

								p1[a].x = test.test(str).get(a).getLatitude();
								// System.out.println(p1[i].x);
								p1[a].y = test.test(str).get(a).getLongitude();
								// System.out.println(p1[i].y);
								// System.out.println(p1[i].getY());
								p2[a] = new Point();
								// System.out.println(p2.length);
								// p2[i].setX(test.test(str2).get(i).getLatitude());
								p2[a].x = test.test(str2).get(a).getLatitude();
								p2[a].y = test.test(str2).get(a).getLongitude();
								// System.out.println(p2[i].y);

							}

							Trajectory t1 = new Trajectory();
							t1.setPoints(p1);
							t1.getPoints();
							// System.out.println(t.t1);
							Trajectory t2 = new Trajectory();
							t2.setPoints(p2);
							System.out.println(dtw.calculateDTW(t1, t2));

						}
					}
				}
			}
		}

	}

	public String readJsonFile(File jsonFile) {
		String jsonStr = "";
		try {
			// File jsonFile = new File(fileName);
			FileReader fileReader = new FileReader(jsonFile);
			Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
			int ch = 0;
			StringBuffer sb = new StringBuffer();
			while ((ch = reader.read()) != -1) {
				sb.append((char) ch);
			}
			fileReader.close();
			reader.close();
			jsonStr = sb.toString();
			return jsonStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Trajectory> test(String str) throws Exception {
		ArrayList<Trajectory> list = new ArrayList<Trajectory>();
		Json object = JSON.parseObject(str, Json.class);
		object.toString();
		for (int i = 0; i < object.locations.size(); i++) {
			Trajectory lc = object.locations.get(i);
			lc.setLatitude(object.locations.get(i).getLatitude());
			lc.setLongitude(object.locations.get(i).getLongitude());
			lc.setTimestamp(object.locations.get(i).getTimestamp());
			list.add(lc);
		}
		return list;
	}

}
