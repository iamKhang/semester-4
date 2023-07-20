package hoangkhang.tuan4.toado_array;

/**
 * 
 * @author thanhCanh Class tạo ra để khởi tạo các menu làm bài tập nhanh hơn
 *
 */

public class Menu {
	private String[] listItem;
	private String title = "MENU";
	private int length;
	private int width;
	private String line1 = "";
	private String line2 = "";
	private String lineStart = "";

	// Chỉ truyền vào mảng
	public Menu(String[] listItem) {
		this.listItem = listItem;
		this.length = listItem.length;
		width = this.getMaxLengthOfItem();
		this.initLine();
	}

	// Truyền thêm tiêu đề menu
	public Menu(String[] listItem, String title) {
		this.listItem = listItem;
		this.length = listItem.length;
		this.title = title;
		width = this.getMaxLengthOfItem();
		this.initLine();
	}

	// Chủ động thiết đặt chiều rộng
	public Menu(String[] listItem, int width) {
		this.listItem = listItem;
		this.length = listItem.length;
		this.width = width;
		this.initLine();
	}

	// 3 tham số
	public Menu(String[] listItem, String title, int width) {
		this.listItem = listItem;
		this.length = listItem.length;
		this.title = title;
		this.width = width;
		this.initLine();
	}

	public int getLength() {
		return this.length;
	}

	// Thiết đặt tiêu đề menu
	public void setTitle(String title) {
		this.title = title;
	}

	// Dùng để căn chỉnh menu tự động theo độ dài các mục
	private int getMaxLengthOfItem() {
		int tmp_max = 0;

		for (int i = 0; i < listItem.length; i++) {
			if (listItem[i].length() > tmp_max)
				tmp_max = listItem[i].length();
		}

		return (tmp_max + 20);
	}

	// Khời tạo các đường kẻ phù hợp với menu (= width)
	private void initLine() {
		int num = (this.width > 40 ? this.width : 60);
		this.width = num;
		for (int i = 0; i < this.width; i++) {
			this.line1 += '-';
			this.line2 += "=";
			this.lineStart += "*";
		}

		this.line1 += '\n';
		this.line2 += '\n';
		this.lineStart += '\n';
	}

	// trả về 1 chuỗi sẽ được căn giữa theo các đường kẻ
	public String centerText(String text) {
		String stringFormat = String.format("%" + String.valueOf(width / 2 + text.length() / 2 + 1) + "s", text);

		return stringFormat;
	}

	// Trả về đường kẻ nếu bạn cần dùng
	public String getLine1() {
		return this.line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public String getLineStart() {
		return this.lineStart;
	}

	public String subTitle(String titleText) {
		return (this.line1 + this.centerText(titleText) + '\n' + this.line1);
	}

	public String subTitle2(String titleText) {
		return (this.line2 + this.centerText(titleText) + '\n' + this.line2);
	}

	public String tableTitle(String titleText) {
		return (this.line1 + titleText + '\n' + this.line1);
	}

	public String question(String quest) {
		return ("\n  • " + quest);
	}

	public String notification(String type, String message) {
		String result = "";

		if (type.equalsIgnoreCase("error"))
			result += "**ERROR: ";
		if (type.equalsIgnoreCase("success"))
			result += "**SUCCESS: ";
		if (type.equalsIgnoreCase("info"))
			result += "**INFO: ";
		if (type.equalsIgnoreCase("warn"))
			result += "**WARN: ";

		return (this.line2 + this.centerText(result + message) + '\n' + this.line2);
	}

//	public static void pressToContinue() {
//		System.out.println(mainMenu.centerText("-/- Nhấn phím bất kỳ để tiếp tục -/-"));
//		try {System.in.read();}
//        catch(Exception e){}
//	}

	@Override
	// Trả về chuỗi chính là menu
	public String toString() {
		String menu = line2 + centerText(title + "\n").toUpperCase() + line2 + '\n';
		for (int i = 0; i < this.listItem.length; i++) {
			menu += (i + 1) + ". " + this.listItem[i] + "\n";
		}
		menu += '\n' + line2;

		return menu;
	}

}
