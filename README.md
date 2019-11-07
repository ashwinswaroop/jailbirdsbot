# JailbirdsBot
JailbirdsBot is a scalable, efficiently designed bot for r/underlords which displays a list and screenshot of the daily jailed heroes along with statistics and inferences based on historical data.

**The need for this application:**

Valve has not released an API for Underlords yet.

**The purpose of this application is to:**

- Read  metadata files kept on a local server

- Store metadata in 2 MongoDB collections. One with derived data and one with only a snapshot of the current data

- Use the derived data to create the Reddit post body with the current jailbird information and screenshot

- Use the snapshot data to calculate notable statistics based on the relation to historial data **(WIP)**

- Combine all the data and create a Reddit post on r/underlords everyday at 6pm PST using a cron scheduler

- Provide the data via an API as an option **(WIP)**

Once implemented in full and released, we should be able to have a steadily increasing dataset of daily changes from which we can make visualization/inferences.

Will be serving https://www.reddit.com/r/underlords/ once complete.


