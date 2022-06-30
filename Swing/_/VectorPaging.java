public class VectorPaging<E> {
	private Vector<E> whole;
	private int perPage = 3;
	
	public VectorPaging(Vector<E> whole){
		this.whole = whole;
	}
	public List<E> getList(int pageNum){
		/*		   index	subList Parameters(끝인덱스 포함안된다)
		 * 1page -> 0~2			->0,3
		 * 2page -> 3~5			->3,6
		 * 3page -> 6~8			->6,9
		 */
		//페이지당 보이는 인덱스를 구할 수 있다.
		int from = (pageNum-1)*perPage;
		int to = from+perPage;
		
		if(to>whole.size()){
			to = whole.size();
		}
		return whole.subList(from, to);
	}
	public int getTotalPageCount(){
		int size = whole.size();//원소 갯수
		int count = size/perPage;
		if(size % perPage !=0){//나누어 떨어지지 않아 남는 원소가 있는지 확인하고 한페이지를 추가
			count++;
		}
		return count;
	}
	public Vector<E> getWhole(){
		return whole;
	}
	public void setWhole(Vector<E> whole){
		this.whole = whole;
	}
	public int getPerPage(){
		return perPage;
	}
	public void setPerPage(int perPage){
		this.perPage = perPage;
	}
	@Override
	public String toString() {
		return "VectorPaging [whole=" + whole + ", perPage=" + perPage + "]";
	}
}
