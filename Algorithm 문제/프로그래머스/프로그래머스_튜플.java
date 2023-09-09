import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
		List<List<Integer>> sortedTuples = getSortedTuples(s);

		Set<Integer> set = new LinkedHashSet<>();

		sortedTuples.forEach(set::addAll);
		
		return set.stream().mapToInt(Integer::intValue).toArray();
	}

	private List<List<Integer>> getSortedTuples(String s) {
		List<List<Integer>> result = new ArrayList<>();

		int startIndex = 1;
		int endIndex = 1;

		for(int i=1;i<s.length()-1;i++) {
			if(s.charAt(i) == '{') {
				startIndex = i;
			} else if(s.charAt(i) == '}') {
				endIndex = i;
				String tupleString = (s.substring(startIndex, endIndex+1));

				result.add(parseTupleByString(tupleString));
			}
		}

		return result.stream().sorted(Comparator.comparing(List::size)).collect(Collectors.toList());
	}

	private List<Integer> parseTupleByString(String s) {
		s = s.replace("{", "").replace("}", "");
		String[] numArray = s.split(",");

		List<Integer> result = new ArrayList<Integer>();

		for(int i = 0 ; i < numArray.length; i++ ) {
			result.add(Integer.parseInt(numArray[i]));
		}

		return result;
	}
}
