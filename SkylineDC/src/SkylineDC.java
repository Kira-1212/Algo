
import java.util.*;

public class SkylineDC {
	public static void main(String [] args)
	{
		double [][] buildings = { {1.8, 2.3, 10.0} , {1.5, 2.1, 8.0,} ,{0.5, 0.8, 4.0}, {2.0, 2.5, 9.0}, {3.0, 4.0, 11.0}, {3.5, 4.2, 8.0}, {3.9, 4.4, 7.0}, {4.1, 4.3, 13.0}, {4.5, 5.2, 6.0},
				{4.6, 5.0, 10.0}, {2.1, 4.7, 5.0}, {2.2, 3.8, 6.0}, {1.1, 1.6, 7.0}, {4.9, 5.7, 13.0}, {5.3, 6.0, 6.0}, {5.4, 5.9, 10.0}};
		
		
		//sorts the array with x1 values
		Arrays.sort(buildings, (a,b) -> Double.compare(a[0], b[0]));
//		for (double[] x : buildings)
//		{
//		   for (double y : x)
//		   {
//		        System.out.print(y + " ");
//		   }
//		   System.out.println();
//		}
		SkylineDC sdc = new SkylineDC();
		List<double[]> finalSkyline = sdc.buildSkyline(0, buildings.length-1, buildings); 
		System.out.println(finalSkyline.size());
		for(int i = 0; i < finalSkyline.size(); i++)
			System.out.println("(" + finalSkyline.get(i)[0] + "," +  finalSkyline.get(i)[1] + ")");
	}
	
	
	public List<double[]> buildSkyline(int first, int last, double [][] buildings){
		List<double[]> skyline = new ArrayList<double[]>();
		
		//base cases 
		
		// when there are no buildings
		if(first>last) 
			return skyline;
		
		// when there is only one building
		else if(first == last) {
			double x1 = buildings[first][0];
			double x2 = buildings[first][1];
			double h = buildings[first][2];
			
			double[] point1 = {x1,h};
			double[] point2 = {x2,0};
			
			skyline.add(point1);
			skyline.add(point2);
			
			return skyline;
			
		}
		// dividing the buildings
		else {
			
			int mid = (first + last)/2;
			List<double[]> skylineLeft =  buildSkyline(first, mid, buildings);
			List<double[]> skylineRight =  buildSkyline(mid+1, last, buildings);
			
			return mergeSkyline(skylineLeft,skylineRight);
			
		}
		
	
	}

	//Code to merge two skylines by comparing each startx, endx and height
	public List<double[]> mergeSkyline(List<double[]> skylineLeft, List<double[]> skylineRight) {
		double h1 = 0.0, h2 = 0.0;
		
		int curr = 0;
		List<double[]> mergedSkyline = new ArrayList<double[]>();
		
		while(!(skylineLeft.isEmpty() || skylineRight.isEmpty())) {
			
			double[] buildingLeft = skylineLeft.get(0);
			double[] buildingRight = skylineRight.get(0);
			
			double[] resultantBuilding = new double[2];
			
			
			if(buildingLeft[0] < buildingRight[0]) {
				resultantBuilding[0] = buildingLeft[0];
				resultantBuilding[1] = buildingLeft[1];
				
				if(buildingLeft[1] < h2) 
					resultantBuilding[1] = h2;
				
				h1 = buildingLeft[1];
				
				skylineLeft.remove(0);
				
			}
			else if(buildingLeft[0] > buildingRight[0]) {
				resultantBuilding[0] = buildingRight[0];
				resultantBuilding[1] = buildingRight[1];
				
				if(buildingRight[1] < h1) 
					resultantBuilding[1] = h1;
				
				h2 = buildingRight[1];
				
				skylineRight.remove(0);
				
			}
			else {
				resultantBuilding[0] = buildingRight[0];
				resultantBuilding[1] = buildingLeft[1] > buildingRight[1] ? buildingLeft[1] : buildingRight[1];
				
				
				h1 = buildingLeft[1];
				h2 = buildingRight[1];
				
				skylineLeft.remove(0);
				skylineRight.remove(0);
			}
			mergedSkyline.add(resultantBuilding);
			
		}
		if(skylineLeft.isEmpty()) {
			while(!skylineRight.isEmpty()) 
				mergedSkyline.add(skylineRight.remove(0));
			
		}
		else {
			while(!skylineLeft.isEmpty()) 
				mergedSkyline.add(skylineLeft.remove(0));
		}
		
		// removes the duplicate coordinates if any
		while(curr < mergedSkyline.size()) {
			int next = curr + 1;
			boolean duplicate = true;
			
			while((next < mergedSkyline.size()) && duplicate) {
				if(mergedSkyline.get(curr)[1] == mergedSkyline.get(next)[1]) {
					duplicate = true;
					mergedSkyline.remove(next);
				}
				else {
					duplicate = false;
				}
			}
			curr++;
		}
		return mergedSkyline;
	}
}
