package hoangkhang.tuan4.toado_array;

public class HinhTronArray {
	private HinhTron[] list;
	public int currSize;

	public HinhTronArray(int initSize) {
		list = new HinhTron[initSize];
		currSize = 0;
	}

	public HinhTron[] getList() {
		return this.list;
	}

	public void extendArraySize() {
		HinhTron[] temp = new HinhTron[list.length * 2];
		System.arraycopy(list, 0, temp, 0, currSize);
		list = temp;
	}

	public int search(String key) {
		for (int i = 0; i < currSize; i++) {
			if (list[i].getTam().getTen().equals(key))
				return i;
		}

		return -1;
	}

	public boolean add(HinhTron newHinhTron) throws Exception {
		if (search(newHinhTron.getTam().getTen()) != -1)
			throw new Exception("Đã tồn tại hình tròn có tâm tên " + newHinhTron.getTam().getTen());

		list[currSize] = newHinhTron;
		currSize++;
		return true;
	}

	public boolean xoa(int index) throws Exception {
		if (index < 0 || index >= currSize) {
			throw new Exception("Không tìm thấy phần tử thứ " + index);
		}

		currSize--;
		for (int i = index; i < currSize; i++) {
			list[i] = list[i + 1];
		}
		return true;
	}

	public void sua(int index, HinhTron modify) throws Exception {
		if (index < 0 || index >= currSize) {
			throw new Exception("Không tìm thấy phần tử thứ " + index);
		}

		list[index] = modify;
	}

	public void sort() {
		// InsertionSort
		for (int i = 1; i < currSize; i++) {
			int index = i;
			HinhTron current = list[i];

			while (index > 0 && current.compareTo(list[index - 1]) < 0) {
				list[index] = list[index - 1];
				index--;
			}

			list[index] = current;
		}
	}

	public void sortBanKinh() {
		// InsertionSort
		for (int i = 1; i < currSize; i++) {
			int index = i;
			HinhTron current = list[i];

			while (index > 0 && current.getBanKinh() > list[index - 1].getBanKinh()) {
				list[index] = list[index - 1];
				index--;
			}

			list[index] = current;
		}
	}
}
