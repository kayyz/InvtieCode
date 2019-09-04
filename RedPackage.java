
public class ReadPackage{
      // 实体类暂时没有,就俩字段,自己搞一下吧
  public static double getRandomMoney(RedPackage _redPackage) {

      // remainSize 剩余的红包数量
      // remainMoney 剩余的钱
      if (_redPackage.remainSize == 1) {
          _redPackage.remainSize--;
          return (double) Math.round(_redPackage.remainMoney * 100) / 100;
      }
      Random r = new Random();
      double min = 0.1; //
      double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
      double money = r.nextDouble() * max;
      money = money <= min ? 0.01 : money;
      money = Math.floor(money * 100) / 100;
      _redPackage.remainSize--;
      _redPackage.remainMoney -= money;
      return money;
  }
}
