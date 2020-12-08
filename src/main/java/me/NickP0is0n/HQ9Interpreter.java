package me.NickP0is0n;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HQ9Interpreter implements Interpreter {
    String sourceCode;
    ArrayList<Object> objectPool = new ArrayList<>();

    HQ9Interpreter(File sourceFile) throws IOException {
        sourceCode = FileUtils.readFile(sourceFile);
    }


    @Override
    public void execute() {
        int counter = 0;
        char[] symbols = sourceCode.toCharArray();

        char lastSymbol = '0';
        for (char symbol: symbols) {
            if (lastSymbol == '+') {
                if (symbol == '+') {
                    counter += 2;
                    objectPool.add(new Object());
                    lastSymbol = '*';
                    continue;
                }
                else {
                    counter++;
                }
            }
            switch (symbol) {
                case 'H': {
                    System.out.println("Hello, world!");
                    break;
                }
                case 'Q': {
                    System.out.println(sourceCode);
                    break;
                }
                case '9': {
                    for (int beer = 99; beer > 1; beer--)
                    {
                        System.out.println(beer + " bottles of beer on the wall, " + beer + " bottles of beer");
                        System.out.println("Take one down, pass it around, " + (beer - 1) + " bottles of beer on the wall!");
                        System.out.println();
                    }
                    System.out.println("1 bottle of beer on the wall, 1 bottle of beer.");
                    System.out.println("Take one down and pass it around, no more bottles of beer on the wall.");
                    System.out.println();
                    System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
                    System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
                    break;
                }
                case '+': {
                    lastSymbol = '+';
                    break;
                }
                case '-': {
                    switch (lastSymbol) {
                        case '0': {
                            try {
                                throw new Exception("Syntax error.");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.exit(1);
                            }
                            break;
                        }

                        case 'H': {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.exit(1);
                            }
                            break;
                        }

                        case 'Q': {
                            recursiveFunction(0);
                            break;
                        }

                        case '9': {
                            while (true) {}
                        }

                        case '+': {
                            int number = 1/0;
                            break;
                        }

                        case '*': {
                            HQ9ExceptionClass hq9ExceptionClass = new HQ9ExceptionClass();
                            try {
                                hq9ExceptionClass.exception();
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.exit(1);
                            }
                        }
                    }
                }
            }
            lastSymbol = symbol;
        }
    }

    private void recursiveFunction(int counter) {
        counter++;
        if (counter == 20000) {
            throw new StackOverflowError();
        }
        recursiveFunction(counter);
    }
}
