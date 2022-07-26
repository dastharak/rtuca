# RT Unicode Converter App

RT Unicode Converter App is a standalone version of the Real Time Unicode Converter.
[SinGlish transliterated](https://ucsc.cmb.ac.lk/ltrl/services/feconverter/).

The converter's code is mainly a Java port of the original Javascript code. 
The additional functionality is to convert the text in clipboard automatically to unicode.
All text copied to clipboard will be converted to Sinhala unicode when the service is running.
*Note: Converter does not check the output is valid Sinhala words.*

## Usage

Start the application by running the run.bat script :
- `start service` to enable converting the clipboard text
- `end service` to disable converting the clipboard text
- `restore last text` to restore the last text converted to unicode

`restore last text` is useful to restore a text you copied to clipboard without realizing the converter is enable.

## Acknowledgement
**This is an independently developed software and I would like to thank the original 
developers and University of Colombo school of Computing for allowing to use the code**

User feedback is highly appreciated!