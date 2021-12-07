//package Task_3;
//
//public class Main {
//
//    void processTask(ChannelHandlerContext ctx) {
//        InetSocketAddress lineAddress = new InetSocketAddress(getIpAddress(), getUdpPort());
//        CommandType typeToRemove;
//        CommandType commandType;
//        String getCommandText;
//        String getHostName;
//        String getHostString;
//        int getPort;
//
//        for (Command currentCommand : getAllCommands()) {
//            commandType = currentCommand.getCommandType();
//            getCommandText = currentCommand.getCommandText();
//            getHostName = lineAddress.getHostName();
//            getPort = lineAddress.getPort();
//            getHostString = lineAddress.getHostString();
//
//            if (commandType == CommandType.REBOOT_CHANNEL) {
//                if (!currentCommand.isAttemptsNumberExhausted()) {
//                    if (currentCommand.isTimeToSend()) {
//                        sendCommandToContext(ctx, lineAddress, getCommandText);
//                        try {
//                            AdminController.getInstance().processUssdMessage(
//                                    new DblIncomeUssdMessage(getHostName, getPort, 0,
//                                            EnumGoip.getByModel(getGoipModel()), getCommandText), false);
//                        } catch (Exception ignored) { }
//                        currentCommand.setSendDate(new Date());
//                        Log.ussd.write(String.format("sent: ip: %s; порт: %d; %s",
//                                getHostString, lineAddress.getPort(), getCommandText));
//                        currentCommand.incSendCounter();
//                    }
//                } else {
//
//                    deleteCommand(commandType);
//                }
//            } else {
//                if (!currentCommand.isAttemptsNumberExhausted()) {
//                    sendCommandToContext(ctx, lineAddress, getCommandText);
//                    try {
//                        AdminController.getInstance().processUssdMessage(
//                                new DblIncomeUssdMessage(getHostName, getPort, 0,
//                                        EnumGoip.getByModel(getGoipModel()), getCommandText), false);
//                    } catch (Exception ignored) { }
//                    Log.ussd.write(String.format("sent: ip: %s; порт: %d; %s",
//                            getHostString, getPort, getCommandText));
//                    currentCommand.setSendDate(new Date());
//                    currentCommand.incSendCounter();
//                } else {
//
//                    deleteCommand(commandType);
//                }
//
//            }
//        }
//        sendKeepAliveOkAndFlush(ctx);
//    }
//
//
//}




