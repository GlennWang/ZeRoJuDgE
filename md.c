#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>
#define LENGTH 1000

int main(int argc, char *argv[])
{
    char buffer[LENGTH];
    char number[10] = {0}, name[LENGTH] = {0};
    char generateFile[5][9] = {"", "\\C", "\\CPP", "\\Java", "\\Python"};
    if (argc >= 3)
    {
        strncpy(number, argv[1], 4); // copy argv1 first 4 char to number (remove the dot)
        strcpy(name, argv[2]);       // copy argv2 to name
        for (int i = 3; i < argc; i++)
        {
            sprintf(buffer, " %s", argv[i]);
            strcat(name, buffer); // add other argv to name (with format)
        }
        for (int i = 0; i < 5; i++)
        {
            sprintf(buffer, "mkdir \"%s. %s%s\"", number, name, generateFile[i]);
            printf("> %s\n", buffer);
            system(buffer); // make empty files by each name
        }
        FILE *fp;
        sprintf(buffer, "%s. %s\\README.md", number, name); // set buffer to file path of README.md
        fp = fopen(buffer, "w");                            // no file detect, so it will generate file with given file path
        if (fp == NULL)
            printf("Cannot create file\n");
        else
            printf("> create %s\n", buffer);
        fclose(fp);
        fp = fopen(buffer, "w"); // file detect, now can do format with it
        printf("> write %s\n", buffer);
        if (fp == NULL)
            printf("Cannot open file\n");
        else
        {
            memset(buffer, '\0', LENGTH); // clear buffer
            sprintf(buffer, "%s. [%s](https://zerojudge.tw/ShowProblem?problemid=%s)", number, name, number);
            for (int i = 0; i < LENGTH; i++)
            {
                if (buffer[i] == '\0') // write butter into README.md
                {
                    fwrite(buffer, sizeof(char), i, fp);
                    break;
                }
            }
            printf("|%s|\n", buffer);
        }
        fclose(fp);
    }
    return 0;
}