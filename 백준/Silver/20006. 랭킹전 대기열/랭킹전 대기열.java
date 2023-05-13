/*
 * 방의 기준(속성) : 인원수 m, 처음 입장한 사람 레벨 -10 ~ +10
 * 유저의 속성 : 레벨 l, 닉네임 n
 * Room = ArrayList<User>
 * */
import java.util.*;
import java.io.*;

class Main {
	
	static class User implements Comparable<User>{
		int level;
		String nickname;
		
		User(int level, String nickname){
			this.level = level;
			this.nickname = nickname;
		}
		
		@Override
		public int compareTo(User o) {
			return this.nickname.compareTo(o.nickname);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int p = Integer.parseInt(st.nextToken()); //플레이어의 수 p
		int m = Integer.parseInt(st.nextToken()); //방의 정원 m
		
		ArrayList<ArrayList<User>> rooms = new ArrayList<>();
		rooms.add(new ArrayList<User>()); //첫 방은 디폴트
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());
			
			boolean canMatch = false;
			//매칭가능한 방 찾기
			label: for(ArrayList<User> room : rooms) {
				//방이 비었으면 입장(처음빼고 안씀)
				if(room.isEmpty()) {
					room.add(user);
					canMatch = true;
					break label;
				} 
				//방이 꽉차있으면 다음방으로
				else if(room.size() == m){
					continue;
				} 
				else {
					if(user.level >= room.get(0).level - 10 && user.level <= room.get(0).level + 10) {
						if(room.size() < m) {
							room.add(user);
							canMatch = true;
							break;
						}
					}
				}
			}
			
			//매칭 가능한 방이 없을 경우
			if(!canMatch) {
				ArrayList<User> newRoom = new ArrayList<>();
				newRoom.add(user);
				rooms.add(newRoom);				
			}
		}
		
		
		
		//모든 방 순회하면서 출력
		for(ArrayList<User> room : rooms) {
			Collections.sort(room);
			if(room.size() == m) {
				sb.append("Started!").append("\n");
				for(User u : room) {
					sb.append(u.level + " " + u.nickname).append("\n");
				}
			} else {
				sb.append("Waiting!").append("\n");
				for(User u : room) {
					sb.append(u.level + " " + u.nickname).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
