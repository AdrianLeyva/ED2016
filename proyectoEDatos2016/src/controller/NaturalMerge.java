/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author adrianleyva
 */
public class NaturalMerge {
    private boolean flag = true;
	
	public void sort(String	filename) throws IOException {
            File tmpFile1 = new	File("tmp1.txt");
            File tmpFile2 = new	File("tmp2.txt");
            File tmpFile3 = new	File("tmp3.txt");								File	file	=	new	File(filename);
            flag = true;

            firstPartition(file, tmpFile2, tmpFile3);

            do	{
                if(flag){
                    partitionFusion(tmpFile2,	tmpFile3,	file,	tmpFile1);
                    flag = false;
                }else{
                    partitionFusion(file,	tmpFile1,	tmpFile2,	tmpFile3);
                    flag = true;
                }

            }	while(	hasData(tmpFile1)	&&	hasData(tmpFile3)	);
        }
        

                protected	void	firstPartition(File	file,	File	tmp2,	File	tmp3)
                throws	IOException	{
                                                Scanner	fileScanner	=	new	Scanner(new	FileReader(file));

                                                FileWriter	fileTmp2Writer;
                                                fileTmp2Writer	=	new	FileWriter(tmp2);
                                                fileTmp2Writer.write("");
                                                fileTmp2Writer.flush();
                                                fileTmp2Writer.close();
                                                fileTmp2Writer	=	new	FileWriter(tmp2,	true);	
                                                PrintWriter	tmpWriter2	=	new	PrintWriter(fileTmp2Writer,	true);

                                                FileWriter	fileTmp3Writer;
                                                fileTmp2Writer	=	new	FileWriter(tmp3);
                                                fileTmp2Writer.write("");
                                                fileTmp2Writer.flush();
                                                fileTmp2Writer.close();
                                                fileTmp2Writer	=	new	FileWriter(tmp3,	true);

                                                PrintWriter	tmpWriter3	=	new	PrintWriter(fileTmp2Writer,	true);

                                                String	line	=	fileScanner.nextLine();
                                                tmpWriter2.println(line);

                                                String	aux	=	line;
                                                flag	=	true;

                                                while	(fileScanner.hasNextLine())	{
                                                                                line	=	fileScanner.nextLine();

                                                                                if	(line.compareTo(aux)	>=	0)	{
                                                                                                                aux	=	line;
                                                                                                                if	(flag)	{
                                                                                                                                                tmpWriter2.println(line);
                                                                                                                }	else	{
                                                                                                                                                tmpWriter3.println(line);																}
                                                                                }	else	{
                                                                                                                if	(flag)	{
                                                                                                                                                tmpWriter3.println(line);
                                                                                                                                                flag	=	false;
                                                                                                                }	else	{
                                                                                                                                                tmpWriter2.println(line);
                                                                                                                                                flag	=	true;
                                                                                                                }
                                                                                }
                                                }
                }

                protected	void	partitionFusion(File	inputFile1,	File	inputFile2,
                File	outputFile1,	File	outputFile2)
                throws	IOException	{
//								Abrir	los	archivos	en	modo	lectura	
                                                Scanner	inputFile1Scanner	=	new	Scanner(new	FileReader(inputFile1));
                                                Scanner	inputFile2Scanner	=	new	Scanner(new	FileReader(inputFile2));
//								Abrir	el	archivo	1	en	modo	escritura	
                                                FileWriter	outputFile1Writer;
                                                outputFile1Writer	=	new	FileWriter(outputFile1);
                                                outputFile1Writer.write("");
                                                outputFile1Writer.flush();
                                                outputFile1Writer.close();
//								Este	archivo	ya	debe	estar	limpio	
                                                outputFile1Writer	=	new	FileWriter(outputFile1,	true);	
                                                FileWriter	outputFile2Writer;
                                                outputFile2Writer	=	new	FileWriter(outputFile2);
                                                outputFile2Writer.write("");
                                                outputFile2Writer.flush();
                                                outputFile2Writer.close();
                                                outputFile2Writer	=	new	FileWriter(outputFile2,	true);

                                                PrintWriter	outputWriter1	=	new	PrintWriter(outputFile1Writer,	true);
                                                PrintWriter	outputWriter2	=	new	PrintWriter(outputFile2Writer,	true);

                                                flag	=	true;
                                                String	aux	=	"";
                                                String	line1	=	inputFile1Scanner.nextLine();
                                                String	line2	=	inputFile2Scanner.nextLine();

                                                if	(line1.compareTo(line2)	<	0)	{
                                                                                aux	=	line1;
                                                }	else	{
                                                                                aux	=	line2;
                                                }

                                                boolean	dele1	=	false;
                                                boolean	dele2	=	false;

                                                while((	inputFile1Scanner.hasNextLine()	||	(!dele1)	)
                                                &&	(	inputFile2Scanner.hasNextLine()	||	(!dele2)	))	{												if	(dele1)	{
                                                                                                                line1	=	inputFile1Scanner.nextLine();
                                                                                                                dele1	=	false;
                                                                                }

                                                                                if	(dele2)	{
                                                                                                                line2	=	inputFile2Scanner.nextLine();
                                                                                                                dele2	=	false;
                                                                                }

                                                                                if	(line1.compareTo(line2)	<	0)	{
                                                                                                                if	(line1.compareTo(aux)	>=	0)	{
                                                                                                                                                aux	=	help1(line1,	outputWriter1,	outputWriter2,	flag);
                                                                                                                                                dele1	=	true;
                                                                                                                }	else	{
                                                                                                                                                if	(line2.compareTo(aux)	>=	0)	{
                                                                                                                                                                                aux	=	help1(line2,	outputWriter1,	outputWriter2,	flag);
                                                                                                                                                                                dele2	=	true;
                                                                                                                                                }	else	{
                                                                                                                                                                                aux	=	help2(line1,	outputWriter1,	outputWriter2);
                                                                                                                                                                                dele1	=	true;
                                                                                                                                                }
                                                                                                                }
                                                                                }	else	{
                                                                                                                if	(line2.compareTo(aux)	>=	0)	{
                                                                                                                                                aux	=	help1(line2,	outputWriter1,	outputWriter2,	flag);
                                                                                                                                                dele2	=	true;																}	else	{
                                                                                                                                                if	(line1.compareTo(aux)	>=	0)	{
                                                                                                                                                                                aux	=	help1(line1,	outputWriter1,	outputWriter2,	flag);
                                                                                                                                                                                dele1	=	true;
                                                                                                                                                }	else	{
                                                                                                                                                                                aux	=	help2(line2,	outputWriter1,	outputWriter2);
                                                                                                                                                                                dele2	=	true;
                                                                                                                                                }
                                                                                                                }
                                                                                }
                                                }

                                                if	(dele1	&&	(!inputFile1Scanner.hasNextLine()))	{
                                                                                help3(aux,	line2,	inputFile2Scanner,
                                                                                outputWriter1,	outputWriter2,	flag);
                                                }

                                                if	(dele2	&&	(!	inputFile2Scanner.hasNextLine()))	{
                                                                                help3(aux,	line1,	inputFile1Scanner,
                                                                                outputWriter1,	outputWriter2,	flag);
                                                }

                                                inputFile1Scanner.close();
                                                inputFile2Scanner.close();
                                                outputFile1Writer.close();
                                                outputFile2Writer.close();
                }	
                private	String	help1(String	line,	PrintWriter	output1,
                PrintWriter	output2,	boolean	flag)	{
                                                if	(flag)	{
                                                                                output1.println(line);
                                                }	else	{
                                                                                output2.println(line);
                                                }

                                                return	line;
                }

                private	String	help2(String	line,	PrintWriter	output1,
                PrintWriter	output2)	{
                                                if	(flag)	{
                                                                                output2.println(line);
                                                                                flag	=	false;
                                                }	else	{
                                                                                output1.println(line);
                                                                                flag	=	true;
                                                }
                                                return	line;
                }

                private	void	help3(String	aux,	String	line,	Scanner	input,
                PrintWriter	output1,	PrintWriter	output2,	boolean	flag)	{
                                                if	(line.compareTo(aux)	>=	0)	{												aux	=	help1(line,	output1,	output2,	flag);
                                                }	else	{
                                                                                aux	=	help2(line,	output1,	output2);
                                                }

                                                while(input.hasNextLine())	{
                                                                                line	=	input.nextLine();

                                                                                if	(line.compareTo(aux)	>=	0)	{
                                                                                                                aux	=	help1(line,	output1,	output2,	flag);
                                                                                }	else	{
                                                                                                                aux	=	help2(line,	output1,	output2);
                                                                                }
                                                }
                }

				private	boolean	hasData(File	file)	throws	FileNotFoundException	{
								Scanner	scanner	=	new	Scanner(new	FileReader(file));
								String	line	=	"";
								int	counter	=	0;
								while	(scanner.hasNextLine())	{
												line	=	scanner.nextLine();
												counter++;
												if	(counter	>	3)	{
																break;
												}
								}								scanner.close();
								boolean	hasData	=	(counter	>=	1);
	
								return	hasData;
				}
}
